package com.example.creatshop.controller;
/*
 * @author HongAnh
 * @created 06 / 11 / 2024 - 7:02 CH
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.constant.Endpoint;
import com.example.creatshop.domain.dto.global.GlobalResponse;
import com.example.creatshop.domain.dto.global.Meta;
import com.example.creatshop.domain.dto.request.PaymentRequest;
import com.example.creatshop.domain.dto.response.PaymentResponse;
import com.example.creatshop.service.PaymentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Log4j2
public class PaymentController {
    PaymentService paymentService;

    @PostMapping(Endpoint.V1.Payment.CREATE_PAYMENT_METHOD)
    public ResponseEntity<GlobalResponse<Meta, PaymentResponse>> createPayment(@RequestBody PaymentRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(paymentService.createPayment(request));
    }

    @PutMapping(Endpoint.V1.Payment.UPDATE_PAYMENT_STATUS)
    public ResponseEntity<GlobalResponse<Meta, PaymentResponse>> updatePayment(@RequestBody PaymentRequest request, @PathVariable(name = "paymentId") Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(paymentService.updatePayment(id, request));
    }
}
