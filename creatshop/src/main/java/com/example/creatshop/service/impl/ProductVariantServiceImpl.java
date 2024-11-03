package com.example.creatshop.service.impl;
/*
 * @author HongAnh
 * @created 03 / 11 / 2024 - 7:30 CH
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.constant.ErrorMessage;
import com.example.creatshop.constant.Status;
import com.example.creatshop.domain.dto.global.GlobalResponse;
import com.example.creatshop.domain.dto.global.Meta;
import com.example.creatshop.domain.dto.request.ProductVariantRequest;
import com.example.creatshop.domain.dto.response.ProductVariantResponse;
import com.example.creatshop.domain.entity.Product;
import com.example.creatshop.domain.entity.ProductVariant;
import com.example.creatshop.domain.mapper.ProductVariantMapper;
import com.example.creatshop.exception.NotFoundException;
import com.example.creatshop.exception.UploadFileException;
import com.example.creatshop.repository.ProductRepository;
import com.example.creatshop.repository.ProductVariantRepository;
import com.example.creatshop.service.ProductVariantService;
import com.example.creatshop.util.CloudinaryUtils;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductVariantServiceImpl implements ProductVariantService {
    ProductRepository        productRepository;
    ProductVariantRepository variantRepository;
    ProductVariantMapper     variantMapper;
    CloudinaryUtils          cloudinaryUtils;


    @Override
    public GlobalResponse<Meta, ProductVariantResponse> createVariant(Integer id, ProductVariantRequest request) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException(ErrorMessage.Product.NOT_FOUND_BY_ID));

        ProductVariant variant = variantMapper.toProductVariant(request);
        variant.setName(product.getName());
        variant.addProduct(product);

        try {
            variant.setImageUrl(cloudinaryUtils.getUrlFromFile(request.getImage()));
        } catch (Exception ex) {
            throw new UploadFileException(ErrorMessage.Product.ERR_FILE_UPLOAD);
        }

        variantRepository.save(variant);

        ProductVariantResponse response = variantMapper.toProductVariantResponse(variant);


        return GlobalResponse.<Meta, ProductVariantResponse>builder()
                             .meta(Meta.builder().status(Status.SUCCESS).build())
                             .data(response).build();
    }
}
