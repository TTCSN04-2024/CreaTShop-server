package com.example.creatshop.controller;
/*
 * @author HongAnh
 * @created 05 / 11 / 2024 - 11:19 CH
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.constant.Endpoint;
import com.example.creatshop.domain.dto.global.GlobalResponse;
import com.example.creatshop.domain.dto.global.Meta;
import com.example.creatshop.domain.dto.request.OrderRequest;
import com.example.creatshop.domain.dto.response.OrderDetailResponse;
import com.example.creatshop.service.OrderDetailService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Log4j2
public class OrderDetailController {
    OrderDetailService orderService;

    @PostMapping(Endpoint.V1.Order.CREATE_ORDER_DETAIL)
    public ResponseEntity<GlobalResponse<Meta, OrderDetailResponse>> createOrderDetail(@AuthenticationPrincipal UserDetails userDetails, @RequestBody OrderRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(orderService.createOrder(userDetails.getUsername(), request));
    }
}
