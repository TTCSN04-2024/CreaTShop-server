package com.example.creatshop.service.impl;
/*
 * @author HongAnh
 * @created 05 / 11 / 2024 - 11:30 CH
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.constant.ErrorMessage;
import com.example.creatshop.constant.Status;
import com.example.creatshop.domain.dto.global.GlobalResponse;
import com.example.creatshop.domain.dto.global.Meta;
import com.example.creatshop.domain.dto.request.OrderItemRequest;
import com.example.creatshop.domain.dto.request.OrderRequest;
import com.example.creatshop.domain.dto.response.OrderDetailResponse;
import com.example.creatshop.domain.dto.response.OrderItemResponse;
import com.example.creatshop.domain.entity.*;
import com.example.creatshop.domain.mapper.OrderDetailMapper;
import com.example.creatshop.domain.mapper.OrderItemMapper;
import com.example.creatshop.domain.mapper.ProductMapper;
import com.example.creatshop.domain.mapper.ProductVariantMapper;
import com.example.creatshop.exception.NotFoundException;
import com.example.creatshop.repository.*;
import com.example.creatshop.service.OrderDetailService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderDetailServiceImpl implements OrderDetailService {
    OrderDetailRepository    orderDetailRepository;
    OrderItemRepository      orderItemRepository;
    ProductRepository        productRepository;
    ProductVariantRepository variantRepository;
    PaymentDetailRepository  paymentDetailRepository;
    UserRepository           userRepository;
    OrderDetailMapper        orderDetailMapper;
    OrderItemMapper          orderItemMapper;
    ProductMapper            productMapper;
    ProductVariantMapper     variantMapper;

    @Override
    public GlobalResponse<Meta, OrderDetailResponse> createOrder(String username, OrderRequest request) {
        User user = userRepository.findByUsername(username)
                                  .orElseThrow(() -> new NotFoundException(ErrorMessage.User.ERR_NOT_FOUND_USERNAME));

        PaymentDetail paymentDetail = paymentDetailRepository.findById(request.getPaymentId())
                                                             .orElseThrow(() -> new NotFoundException(ErrorMessage.Payment.ERR_NOT_FOUND_BY_ID));

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setUser(user);
        orderDetail.setPaymentDetail(paymentDetail);

        List<OrderItem> orderItems = new ArrayList<>();
        Double total = 0.0;

        for (var item : request.getOrderItems()) {
            Product product = productRepository.findById(item.getProductId())
                                               .orElseThrow(() -> new NotFoundException(ErrorMessage.Product.NOT_FOUND_BY_ID));

            ProductVariant variant = variantRepository.findById(item.getVariantId())
                                                      .orElseThrow(() -> new NotFoundException(ErrorMessage.ProductVariant.NOT_FOUND_BY_ID));

            OrderItem orderItem = OrderItem.builder()
                                           .product(product)
                                           .variant(variant)
                                           .orderDetail(orderDetail)
                                           .quantity(item.getQuantity())
                                           .orderDetail(orderDetail)
                                           .build();

            Double itemTotal = calculatorTotal(item.getProductId(), item.getQuantity());
            total += itemTotal;

            orderItems.add(orderItem);
        }

        orderDetail.setTotal(total);
        orderDetail = orderDetailRepository.save(orderDetail);
        orderItems = new ArrayList<>(orderItemRepository.saveAll(orderItems));

        OrderDetailResponse response = orderDetailMapper.toOrderDetailResponse(orderDetail);
        response.setOrderItems(orderItems.stream()
                                         .map(orderItem -> {
                                             OrderItemResponse itemResponse = orderItemMapper.toOrderItemResponse(orderItem);
                                             itemResponse.setProduct(productMapper.toProductResponse(orderItem.getProduct()));
                                             itemResponse.setVariant(variantMapper.toProductVariantResponse(orderItem.getVariant()));

                                             return itemResponse;
                                         })
                                         .collect(Collectors.toList())
        );

        return GlobalResponse.<Meta, OrderDetailResponse>builder()
                             .meta(Meta.builder().status(Status.SUCCESS).build())
                             .data(response)
                             .build();
    }

    private Double calculatorTotal(Integer productId, Integer quantity) {
        Product product = productRepository.findById(productId)
                                           .orElseThrow(() -> new NotFoundException(ErrorMessage.Product.NOT_FOUND_BY_ID));

        Double price = product.getPrice();

        return price * quantity;
    }
}
