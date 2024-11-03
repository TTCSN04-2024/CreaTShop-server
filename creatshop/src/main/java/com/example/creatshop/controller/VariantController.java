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
}
