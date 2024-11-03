package com.example.creatshop.controller;
/*
 * @author HongAnh
 * @created 26 / 09 / 2024 - 10:40 AM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.constant.Endpoint;
import com.example.creatshop.domain.dto.global.GlobalResponse;
import com.example.creatshop.domain.dto.global.Meta;
import com.example.creatshop.domain.dto.request.ProductRequest;
import com.example.creatshop.domain.dto.response.ProductResponse;
import com.example.creatshop.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Log4j2
public class ProductController {
    ProductService productService;

    @PostMapping(Endpoint.V1.Product.CREATE_PRODUCT)
    public ResponseEntity<GlobalResponse<Meta, ProductResponse>> createProduct(@ModelAttribute ProductRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productService.createProduct(request));
    }

    @GetMapping(Endpoint.V1.Product.GET_PRODUCT)
    public ResponseEntity<GlobalResponse<Meta, List<ProductResponse>>> getProducts() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.getProducts());
    }

    @GetMapping(Endpoint.V1.Product.GET_PRODUCT_BY_ID)
    public ResponseEntity<GlobalResponse<Meta, ProductResponse>> getProduct(@PathVariable(name = "productId") Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.getProduct(id));
    }
}
