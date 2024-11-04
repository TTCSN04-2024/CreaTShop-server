package com.example.creatshop.service;
/*
 * @author HongAnh
 * @created 04 / 11 / 2024 - 10:01 CH
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.domain.dto.global.GlobalResponse;
import com.example.creatshop.domain.dto.global.Meta;
import com.example.creatshop.domain.dto.request.AddressRequest;
import com.example.creatshop.domain.dto.response.AddressResponse;

public interface AddressService {
    GlobalResponse<Meta, AddressResponse> createAddress(String username, AddressRequest request);
}
