package com.example.creatshop.domain.mapper;
/*
 * @author HongAnh
 * @created 05 / 11 / 2024 - 11:32 CH
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.domain.dto.response.OrderItemResponse;
import com.example.creatshop.domain.entity.OrderItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    OrderItemResponse toOrderItemResponse(OrderItem orderItem);
}
