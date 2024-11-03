package com.example.creatshop.controller;
/*
 * @author HongAnh
 * @created 24 / 09 / 2024 - 2:58 PM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.constant.Endpoint;
import com.example.creatshop.domain.dto.global.GlobalResponse;
import com.example.creatshop.domain.dto.global.Meta;
import com.example.creatshop.domain.dto.request.CategoryRequest;
import com.example.creatshop.domain.dto.response.CategoryResponse;
import com.example.creatshop.domain.dto.response.CategoryTypeResponse;
import com.example.creatshop.service.CategoryService;
import jakarta.validation.Valid;
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
@RequiredArgsConstructor
@Log4j2
public class CategoryController {
    CategoryService categoryService;

    @PostMapping(Endpoint.V1.Category.CREATE_CATEGORY)
    public ResponseEntity<GlobalResponse<Meta, CategoryResponse>> createCate(@RequestBody @Valid CategoryRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoryService.createCategory(request));
    }

    @PutMapping(Endpoint.V1.Category.UPDATE_CATEGORY)
    public ResponseEntity<GlobalResponse<Meta, CategoryResponse>> updateCate(@PathVariable(name = "id") Integer cateId, @RequestBody CategoryRequest request) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(categoryService.updateCategory(cateId, request));
    }

    @DeleteMapping(Endpoint.V1.Category.DELETE_CATEGORY)
    public ResponseEntity<GlobalResponse<Meta, String>> deleteCate(@PathVariable(name = "id") Integer cateId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(categoryService.deleteCategory(cateId));
    }

    @GetMapping(Endpoint.V1.Category.GET_CATEGORY)
    public ResponseEntity<GlobalResponse<Meta, List<CategoryTypeResponse>>> getAllCate() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(categoryService.getAllCategories());
    }

    @GetMapping(Endpoint.V1.Category.GET_CATEGORY_BY_ID)
    public ResponseEntity<GlobalResponse<Meta, CategoryResponse>> getCategory(@PathVariable(name = "categoryId") Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(categoryService.getCategory(id));
    }
}
