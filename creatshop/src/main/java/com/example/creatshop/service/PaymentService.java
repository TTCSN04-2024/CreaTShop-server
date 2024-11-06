package com.example.creatshop.service;
/*
 * @author HongAnh
 * @created 06 / 11 / 2024 - 7:03 CH
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.domain.dto.global.GlobalResponse;
import com.example.creatshop.domain.dto.global.Meta;
import com.example.creatshop.domain.dto.request.PaymentRequest;
import com.example.creatshop.domain.dto.response.PaymentResponse;
import org.springframework.http.ResponseEntity;

public interface PaymentService {
    GlobalResponse<Meta, PaymentResponse> createPayment(PaymentRequest request);

    GlobalResponse<Meta, PaymentResponse> updatePayment(Integer id, PaymentRequest request);
}
