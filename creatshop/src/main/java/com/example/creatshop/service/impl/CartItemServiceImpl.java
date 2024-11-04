package com.example.creatshop.service.impl;
/*
 * @author HongAnh
 * @created 04 / 11 / 2024 - 5:53 CH
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.constant.ErrorMessage;
import com.example.creatshop.constant.Status;
import com.example.creatshop.domain.dto.global.GlobalResponse;
import com.example.creatshop.domain.dto.global.Meta;
import com.example.creatshop.domain.dto.request.CartItemRequest;
import com.example.creatshop.domain.dto.response.CartItemResponse;
import com.example.creatshop.domain.entity.*;
import com.example.creatshop.domain.mapper.CartItemMapper;
import com.example.creatshop.domain.mapper.ProductMapper;
import com.example.creatshop.domain.mapper.ProductVariantMapper;
import com.example.creatshop.exception.BadRequestException;
import com.example.creatshop.exception.NotFoundException;
import com.example.creatshop.repository.*;
import com.example.creatshop.service.CartItemService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Log4j2
public class CartItemServiceImpl implements CartItemService {
    CartItemRepository       cartItemRepository;
    UserRepository           userRepository;
    ProductRepository        productRepository;
    ProductVariantRepository variantRepository;
    CartItemMapper           cartItemMapper;
    ProductMapper            productMapper;
    ProductVariantMapper     variantMapper;


    @Override
    public GlobalResponse<Meta, CartItemResponse> addCartItem(String username, CartItemRequest request) {
        User user = userRepository.findByUsername(username)
                                  .orElseThrow(() -> new NotFoundException(ErrorMessage.User.ERR_NOT_FOUND_USERNAME));

        if (Objects.isNull(request.getQuantity()) || request.getQuantity() <= 0) {
            throw new BadRequestException(ErrorMessage.CartItem.ERR_QUANTITY_COUNT);
        }

        Product product = productRepository.findById(request.getProductId())
                                           .orElseThrow(() -> new NotFoundException(ErrorMessage.Product.NOT_FOUND_BY_ID));

        ProductVariant variant = variantRepository.findById(request.getVariantId())
                                                  .orElseThrow(() -> new NotFoundException(ErrorMessage.ProductVariant.NOT_FOUND_BY_ID));
        boolean flag = false;
        for (var item : product.getProductVariants()) {
            if (item.getId().equals(variant.getId())) {
                flag = true;
            }
        }

        if (flag == false) {
            throw new BadRequestException(ErrorMessage.Product.ERR_NOT_CONTAIN_VARIANT);
        }

        CartItem cartItem = CartItem.builder()
                                    .product(product)
                                    .productVariant(variant)
                                    .cart(user.getCart())
                                    .quantity(request.getQuantity())
                                    .build();

        cartItem = cartItemRepository.save(cartItem);

        CartItemResponse response = cartItemMapper.toCartItemResponse(cartItem);
        response.setProductResponse(productMapper.toProductResponse(cartItem.getProduct()));
        response.setProductDetail(variantMapper.toProductVariantResponse(cartItem.getProductVariant()));

        return GlobalResponse.<Meta, CartItemResponse>builder()
                             .meta(Meta.builder().status(Status.SUCCESS).build())
                             .data(response)
                             .build();
    }
}
