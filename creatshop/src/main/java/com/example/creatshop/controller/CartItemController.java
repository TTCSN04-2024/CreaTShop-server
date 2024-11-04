package com.example.creatshop.controller;
/*
 * @author HongAnh
 * @created 04 / 11 / 2024 - 5:38 CH
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.constant.Endpoint;
import com.example.creatshop.domain.dto.global.GlobalResponse;
import com.example.creatshop.domain.dto.global.Meta;
import com.example.creatshop.domain.dto.request.CartItemRequest;
import com.example.creatshop.domain.dto.response.CartItemResponse;
import com.example.creatshop.service.CartItemService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Log4j2
public class CartItemController {
    CartItemService cartService;

    @PostMapping(Endpoint.V1.Cart.ADD_CART_ITEM)
    public ResponseEntity<GlobalResponse<Meta, CartItemResponse>> addCartItem(@AuthenticationPrincipal UserDetails userDetails, @RequestBody CartItemRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(cartService.addCartItem(userDetails.getUsername(), request));
    }

    @GetMapping(Endpoint.V1.Cart.GET_CART_ITEM)
    public ResponseEntity<GlobalResponse<Meta, List<CartItemResponse>>> getCartItem(@AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cartService.getCartItem(userDetails.getUsername()));
    }

    @GetMapping(Endpoint.V1.Cart.GET_CART_ITEM_BY_ID)
    public ResponseEntity<GlobalResponse<Meta, CartItemResponse>> getCartItemById(@AuthenticationPrincipal UserDetails userDetails, @PathVariable(name = "cartItemId") Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cartService.getCartItemById(userDetails.getUsername(), id));
    }

    @PutMapping(Endpoint.V1.Cart.UPDATE_CART_ITEM)
    public ResponseEntity<GlobalResponse<Meta, CartItemResponse>> updateCartItem(@AuthenticationPrincipal UserDetails userDetails, @PathVariable(name = "cartItemId") Integer id, @RequestBody CartItemRequest request) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cartService.updateCartItem(userDetails.getUsername(), id, request));
    }
}
