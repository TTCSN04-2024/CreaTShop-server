package com.example.creatshop.domain.mapper;
/*
 * @author HongAnh
 * @created 06 / 11 / 2024 - 6:18 CH
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.domain.dto.response.OrderDetailResponse;
import com.example.creatshop.domain.entity.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OrderDetailMapper {
    @Mapping(target = "user", ignore = true)
    OrderDetailResponse toOrderDetailResponse(OrderDetail orderDetail);
}
