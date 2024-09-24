package com.example.creatshop.service.impl;
/*
 * @author HongAnh
 * @created 24 / 09 / 2024 - 3:07 PM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.constant.ErrorMessage;
import com.example.creatshop.constant.Status;
import com.example.creatshop.domain.dto.global.GlobalResponse;
import com.example.creatshop.domain.dto.global.Meta;
import com.example.creatshop.domain.dto.request.CategoryRequest;
import com.example.creatshop.domain.dto.response.CategoryResponse;
import com.example.creatshop.domain.entity.Category;
import com.example.creatshop.domain.mapper.CategoryMapper;
import com.example.creatshop.exception.AlreadyExistsException;
import com.example.creatshop.exception.NotFoundException;
import com.example.creatshop.repository.CategoryRepository;
import com.example.creatshop.service.CategoryService;
import com.example.creatshop.util.EnumUtils;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Log4j2
public class CategoryServiceImpl implements CategoryService {
    CategoryRepository categoryRepository;

    CategoryMapper categoryMapper;

    EnumUtils enumUtils;

    @Override
    public GlobalResponse<Meta, CategoryResponse> createCategory(CategoryRequest request) {

        if (categoryRepository.existsByName(request.getName())) {
            throw new AlreadyExistsException(ErrorMessage.Category.EXISTS_BY_NAME);
        }

        if (!enumUtils.isValidEnumValue(request.getType())) {
            throw new NotFoundException(ErrorMessage.Category.NOT_FOUND_TYPE);
        }

        Category category = categoryMapper.toCategory(request);
        category.setType(enumUtils.fromString(request.getType()));

        category = categoryRepository.save(category);

        CategoryResponse response = categoryMapper.toCategoryResponse(category);

        return GlobalResponse.<Meta, CategoryResponse>builder()
                             .meta(Meta.builder().status(Status.SUCCESS).build())
                             .data(response)
                             .build();
    }

    @Override
    public GlobalResponse<Meta, CategoryResponse> updateCategory(Integer id, CategoryRequest request) {

        if (StringUtils.hasText(request.getName()) && categoryRepository.existsByName(request.getName())) {
            throw new AlreadyExistsException(ErrorMessage.Category.EXISTS_BY_NAME);
        }

        if (StringUtils.hasText(request.getType()) && !enumUtils.isValidEnumValue(request.getType())) {
            throw new NotFoundException(ErrorMessage.Category.NOT_FOUND_TYPE);
        }

        Category category = categoryRepository.findById(id)
                                              .orElseThrow(() -> new NotFoundException(ErrorMessage.Category.NOT_FOUND_BY_ID));

        categoryMapper.updateCategory(request, category);

        if (StringUtils.hasText(request.getType())) {
            category.setType(enumUtils.fromString(request.getType()));
        }

        category = categoryRepository.save(category);

        CategoryResponse response = categoryMapper.toCategoryResponse(category);

        return GlobalResponse.<Meta, CategoryResponse>builder()
                             .meta(Meta.builder().status(Status.SUCCESS).build())
                             .data(response)
                             .build();
    }
}
