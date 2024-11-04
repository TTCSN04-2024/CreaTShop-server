package com.example.creatshop.domain.mapper;
/*
 * @author HongAnh
 * @created 04 / 11 / 2024 - 5:53 CH
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.domain.dto.request.CartItemRequest;
import com.example.creatshop.domain.dto.response.CartItemResponse;
import com.example.creatshop.domain.entity.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CartItemMapper {

    CartItemResponse toCartItemResponse(CartItem cartItem);

    void updateCartItem(CartItemRequest request, @MappingTarget CartItem cartItem);
}
