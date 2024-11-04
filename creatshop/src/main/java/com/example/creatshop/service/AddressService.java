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

import java.util.List;

public interface AddressService {
    GlobalResponse<Meta, AddressResponse> createAddress(String username, AddressRequest request);

    GlobalResponse<Meta, List<AddressResponse>> getAddress(String username);

    GlobalResponse<Meta, AddressResponse> getAddressById(String username, Integer id);

    GlobalResponse<Meta, String> deleteAddress(String username, Integer id);
}
