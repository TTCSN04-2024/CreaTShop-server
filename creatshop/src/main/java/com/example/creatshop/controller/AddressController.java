package com.example.creatshop.controller;
/*
 * @author HongAnh
 * @created 04 / 11 / 2024 - 9:58 CH
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.constant.Endpoint;
import com.example.creatshop.domain.dto.global.GlobalResponse;
import com.example.creatshop.domain.dto.global.Meta;
import com.example.creatshop.domain.dto.request.AddressRequest;
import com.example.creatshop.domain.dto.response.AddressResponse;
import com.example.creatshop.service.AddressService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
public class AddressController {
    AddressService addressService;

    @PostMapping(Endpoint.V1.Address.ADD_ADDRESS)
    public ResponseEntity<GlobalResponse<Meta, AddressResponse>> addAddress(@AuthenticationPrincipal UserDetails userDetails,
                                                                            @RequestBody AddressRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(addressService.createAddress(userDetails.getUsername(), request));
    }

    @GetMapping(Endpoint.V1.Address.GET_ADDRESS)
    public ResponseEntity<GlobalResponse<Meta, List<AddressResponse>>> getAddress(@AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(addressService.getAddress(userDetails.getUsername()));
    }

    @GetMapping(Endpoint.V1.Address.GET_ADDRESS_BY_ID)
    public ResponseEntity<GlobalResponse<Meta, AddressResponse>> getAddressById(@AuthenticationPrincipal UserDetails userDetails,
                                                                                @PathVariable(name = "addressId") Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(addressService.getAddressById(userDetails.getUsername(), id));
    }

    @DeleteMapping(Endpoint.V1.Address.DELETE_ADDRESS)
    public ResponseEntity<GlobalResponse<Meta, String>> deleteAddress(@AuthenticationPrincipal UserDetails userDetails,
                                                                      @PathVariable(name = "addressId") Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(addressService.deleteAddress(userDetails.getUsername(), id));
    }

    @PutMapping(Endpoint.V1.Address.UPDATE_ADDRESS)
    public ResponseEntity<GlobalResponse<Meta, AddressResponse>> updateAddress(@AuthenticationPrincipal UserDetails userDetails,
                                                                               @PathVariable(name = "addressId") Integer id,
                                                                               @RequestBody AddressRequest request) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(addressService.updateAddress(userDetails.getUsername(), id, request));
    }
}
