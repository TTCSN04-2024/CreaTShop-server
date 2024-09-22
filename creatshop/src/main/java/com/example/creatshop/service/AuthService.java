package com.example.creatshop.service;
/*
 * @author HongAnh
 * @created 22 / 09 / 2024 - 4:50 PM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.domain.dto.global.GlobalResponse;
import com.example.creatshop.domain.dto.global.Meta;
import com.example.creatshop.domain.dto.request.LoginRequest;
import com.example.creatshop.domain.dto.response.AuthResponse;

public interface AuthService {

    GlobalResponse<Meta, AuthResponse> login(LoginRequest request);


}
