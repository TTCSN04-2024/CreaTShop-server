package com.example.creatshop.service.impl;
/*
 * @author HongAnh
 * @created 22 / 09 / 2024 - 7:21 PM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.constant.ErrorMessage;
import com.example.creatshop.constant.RoleType;
import com.example.creatshop.constant.Status;
import com.example.creatshop.domain.dto.global.GlobalResponse;
import com.example.creatshop.domain.dto.global.Meta;
import com.example.creatshop.domain.dto.request.UserRequest;
import com.example.creatshop.domain.dto.response.UserResponse;
import com.example.creatshop.domain.entity.Cart;
import com.example.creatshop.domain.entity.Role;
import com.example.creatshop.domain.entity.User;
import com.example.creatshop.domain.mapper.UserMapper;
import com.example.creatshop.exception.NotFoundException;
import com.example.creatshop.repository.CartRepository;
import com.example.creatshop.repository.RoleRepository;
import com.example.creatshop.repository.UserRepository;
import com.example.creatshop.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Log4j2
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    RoleRepository roleRepository;
    CartRepository cartRepository;

    UserMapper userMapper;

    PasswordEncoder passwordEncoder;

    @Override
    public GlobalResponse<Meta, UserResponse> createUser(UserRequest request) {

        User user = userMapper.toUser(request);

        if (!roleRepository.existsByType(RoleType.ROLE_USER)) {
            Role role = Role.builder()
                            .type(RoleType.ROLE_USER)
                            .description("This is role for user")
                            .build();

            roleRepository.save(role);
        }

        Role role = roleRepository.findByType(RoleType.ROLE_USER)
                                  .orElseThrow(() -> new NotFoundException(ErrorMessage.Role.NOT_FOUND_BY_TYPE));
        user.setRole(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = userRepository.save(user);

        if (Objects.isNull(savedUser.getCart())) {
            Cart cart = Cart.builder()
                            .cartTotal(0.0).build();

            savedUser.addCart(cart);

            cartRepository.save(cart);
        }

        UserResponse response = userMapper.toUserResponse(savedUser);

        return GlobalResponse
                .<Meta, UserResponse>builder()
                .meta(Meta.builder().status(Status.SUCCESS).build())
                .data(response)
                .build();
    }
}
