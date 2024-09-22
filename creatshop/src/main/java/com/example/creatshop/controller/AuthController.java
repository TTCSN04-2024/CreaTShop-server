package com.example.creatshop.controller;
/*
 * @author HongAnh
 * @created 22 / 09 / 2024 - 4:51 PM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.constant.Endpoint;
import com.example.creatshop.domain.dto.global.GlobalResponse;
import com.example.creatshop.domain.dto.global.Meta;
import com.example.creatshop.domain.dto.request.LoginRequest;
import com.example.creatshop.domain.dto.response.AuthResponse;
import com.example.creatshop.service.AuthService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
public class AuthController {
    AuthService           authService;

    @PostMapping(Endpoint.V1.Auth.LOGIN)
    public ResponseEntity<GlobalResponse<Meta, AuthResponse>> login(@RequestBody @Valid LoginRequest request) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authService.login(request));
    }
}
