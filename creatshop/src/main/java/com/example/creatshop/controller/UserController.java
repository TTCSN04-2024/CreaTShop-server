package com.example.creatshop.controller;
/*
 * @author HongAnh
 * @created 22 / 09 / 2024 - 7:22 PM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.constant.Endpoint;
import com.example.creatshop.domain.dto.global.GlobalResponse;
import com.example.creatshop.domain.dto.global.Meta;
import com.example.creatshop.domain.dto.request.UserRequest;
import com.example.creatshop.domain.dto.response.UserResponse;
import com.example.creatshop.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;

    @PostMapping(Endpoint.V1.User.CREATE_USER)
    public ResponseEntity<GlobalResponse<Meta, UserResponse>> createUser(@RequestBody @Valid UserRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.createUser(request));
    }

//    @PreAuthorize("#request.username == principal.username or hasRole('ADMIN')")
    @PutMapping(Endpoint.V1.User.UPDATE_USER)
    public ResponseEntity<GlobalResponse<Meta, UserResponse>> updateUser(@RequestBody UserRequest request,
                                                                         @AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.updateUser(request, userDetails.getUsername()));
    }
}
