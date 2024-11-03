package com.example.creatshop.service;
/*
 * @author HongAnh
 * @created 24 / 09 / 2024 - 2:58 PM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.domain.dto.global.GlobalResponse;
import com.example.creatshop.domain.dto.global.Meta;
import com.example.creatshop.domain.dto.request.CategoryRequest;
import com.example.creatshop.domain.dto.response.CategoryResponse;
import com.example.creatshop.domain.dto.response.CategoryTypeResponse;

import java.util.List;

public interface CategoryService {
    GlobalResponse<Meta, CategoryResponse> createCategory(CategoryRequest request);

    GlobalResponse<Meta, CategoryResponse> updateCategory(Integer id, CategoryRequest request);

    GlobalResponse<Meta, String> deleteCategory(Integer cateId);

    GlobalResponse<Meta, List<CategoryTypeResponse>> getAllCategories();

    GlobalResponse<Meta, CategoryResponse> getCategory(Integer id);
}
