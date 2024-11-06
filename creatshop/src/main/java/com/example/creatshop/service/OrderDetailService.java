package com.example.creatshop.service;
/*
 * @author HongAnh
 * @created 05 / 11 / 2024 - 11:20 CH
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.domain.dto.global.GlobalResponse;
import com.example.creatshop.domain.dto.global.Meta;
import com.example.creatshop.domain.dto.request.OrderRequest;
import com.example.creatshop.domain.dto.response.OrderDetailResponse;

import java.util.List;

public interface OrderDetailService {
    GlobalResponse<Meta, OrderDetailResponse> createOrder(String username, OrderRequest request);
}
