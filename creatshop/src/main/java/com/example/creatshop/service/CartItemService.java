package com.example.creatshop.service;
/*
 * @author HongAnh
 * @created 04 / 11 / 2024 - 5:43 CH
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.domain.dto.global.GlobalResponse;
import com.example.creatshop.domain.dto.global.Meta;
import com.example.creatshop.domain.dto.request.CartItemRequest;
import com.example.creatshop.domain.dto.response.CartItemResponse;

public interface CartItemService {
    GlobalResponse<Meta, CartItemResponse> addCartItem(String username, CartItemRequest request);
}
