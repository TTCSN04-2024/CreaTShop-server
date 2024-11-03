package com.example.creatshop.service;
/*
 * @author HongAnh
 * @created 03 / 11 / 2024 - 7:21 CH
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.domain.dto.global.GlobalResponse;
import com.example.creatshop.domain.dto.global.Meta;
import com.example.creatshop.domain.dto.request.ProductVariantRequest;
import com.example.creatshop.domain.dto.response.ProductVariantResponse;

import java.util.List;

public interface ProductVariantService {
    GlobalResponse<Meta, ProductVariantResponse> createVariant(Integer id, ProductVariantRequest request);

    GlobalResponse<Meta, List<ProductVariantResponse>> getVariantByProductId(Integer id);

    GlobalResponse<Meta, List<ProductVariantResponse>> getVariant();

    GlobalResponse<Meta, ProductVariantResponse> getVariant(Integer id);

    GlobalResponse<Meta, ProductVariantResponse> updateVariant(Integer id, ProductVariantRequest request);
}
