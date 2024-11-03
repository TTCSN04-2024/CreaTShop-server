package com.example.creatshop.controller;
/*
 * @author HongAnh
 * @created 03 / 11 / 2024 - 7:20 CH
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.constant.Endpoint;
import com.example.creatshop.domain.dto.global.GlobalResponse;
import com.example.creatshop.domain.dto.global.Meta;
import com.example.creatshop.domain.dto.request.ProductVariantRequest;
import com.example.creatshop.domain.dto.response.ProductVariantResponse;
import com.example.creatshop.service.ProductVariantService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Log4j2
@RequiredArgsConstructor
public class VariantController {
    ProductVariantService variantService;

    @PostMapping(Endpoint.V1.Variant.CREATE_VARIANT)
    public ResponseEntity<GlobalResponse<Meta, ProductVariantResponse>> createVariant(@PathVariable(name = "productId") Integer id, @ModelAttribute ProductVariantRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(variantService.createVariant(id, request));
    }

    @GetMapping(Endpoint.V1.Variant.GET_VARIANT_BY_PRODUCT)
    public ResponseEntity<GlobalResponse<Meta, List<ProductVariantResponse>>> getProductVariant(@PathVariable(name = "productId") Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(variantService.getVariantByProductId(id));
    }

    @GetMapping(Endpoint.V1.Variant.GET_VARIANT)
    public ResponseEntity<GlobalResponse<Meta, List<ProductVariantResponse>>> getProductVariant() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(variantService.getVariant());
    }

    @GetMapping(Endpoint.V1.Variant.GET_VARIANT_BY_ID)
    public ResponseEntity<GlobalResponse<Meta, ProductVariantResponse>> getProductVariantById(@PathVariable(name = "variantId") Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(variantService.getVariant(id));
    }

    @PutMapping(Endpoint.V1.Variant.UPDATE_VARIANT)
    public ResponseEntity<GlobalResponse<Meta, ProductVariantResponse>> updateProductVariant(@PathVariable(name = "variantId") Integer id, @ModelAttribute ProductVariantRequest request) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(variantService.updateVariant(id, request));
    }

    @DeleteMapping(Endpoint.V1.Variant.DELETE_VARIANT)
    public ResponseEntity<GlobalResponse<Meta, String>> deleteProductVariant(@PathVariable(name = "variantId") Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(variantService.deleteVariant(id));
    }
}
