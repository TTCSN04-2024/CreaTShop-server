package com.example.creatshop.domain.mapper;
/*
 * @author HongAnh
 * @created 22 / 09 / 2024 - 7:32 PM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.domain.dto.request.UserRequest;
import com.example.creatshop.domain.dto.request.UserUpdateRequest;
import com.example.creatshop.domain.dto.response.UserResponse;
import com.example.creatshop.domain.entity.User;
import org.mapstruct.*;


@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    User toUser(UserRequest request);
    UserResponse toUserResponse(User user);

    @Mapping(target = "username", ignore = true)
    void updateUser(UserUpdateRequest request, @MappingTarget User user);
}
