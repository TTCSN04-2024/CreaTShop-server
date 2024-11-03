package com.example.creatshop.domain.mapper;
/*
 * @author HongAnh
 * @created 23 / 09 / 2024 - 7:16 PM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.domain.dto.request.ProductVariantRequest;
import com.example.creatshop.domain.dto.response.ProductVariantResponse;
import com.example.creatshop.domain.entity.ProductVariant;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductVariantMapper {
    ProductVariant toProductVariant(ProductVariantRequest request);
    ProductVariantResponse toProductVariantResponse(ProductVariant productVariant);
    void updateProductVariant(ProductVariantRequest request, @MappingTarget ProductVariant variant);
}
