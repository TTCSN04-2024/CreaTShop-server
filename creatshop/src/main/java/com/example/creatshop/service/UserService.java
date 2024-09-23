package com.example.creatshop.service;
/*
 * @author HongAnh
 * @created 22 / 09 / 2024 - 7:21 PM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.domain.dto.global.GlobalResponse;
import com.example.creatshop.domain.dto.global.Meta;
import com.example.creatshop.domain.dto.request.UserRequest;
import com.example.creatshop.domain.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    GlobalResponse<Meta, UserResponse> createUser(UserRequest request);

    GlobalResponse<Meta, UserResponse> updateUser(UserRequest request, String username);

    GlobalResponse<Meta, UserResponse> getUser(String username);

    GlobalResponse<Meta, List<UserResponse>> getUsers();
}
