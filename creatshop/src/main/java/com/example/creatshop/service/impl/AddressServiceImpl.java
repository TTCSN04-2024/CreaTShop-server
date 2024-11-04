package com.example.creatshop.service.impl;

import com.example.creatshop.constant.ErrorMessage;
import com.example.creatshop.constant.Status;
import com.example.creatshop.domain.dto.global.GlobalResponse;
import com.example.creatshop.domain.dto.global.Meta;
import com.example.creatshop.domain.dto.request.AddressRequest;
import com.example.creatshop.domain.dto.response.AddressResponse;
import com.example.creatshop.domain.entity.Address;
import com.example.creatshop.domain.entity.User;
import com.example.creatshop.domain.mapper.AddressMapper;
import com.example.creatshop.exception.NotFoundException;
import com.example.creatshop.repository.AddressRepository;
import com.example.creatshop.repository.UserRepository;
import com.example.creatshop.service.AddressService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/*
 * @author HongAnh
 * @created 04 / 11 / 2024 - 10:12 CH
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Log4j2
public class AddressServiceImpl implements AddressService {
    AddressRepository addressRepository;
    UserRepository    userRepository;
    AddressMapper     addressMapper;

    @Override
    public GlobalResponse<Meta, AddressResponse> createAddress(String username, AddressRequest request) {
        User user = userRepository.findByUsername(username)
                                  .orElseThrow(() -> new NotFoundException(ErrorMessage.User.ERR_NOT_FOUND_USERNAME));

        Address address = addressMapper.toAddress(request);
        address.addUser(user);

        address = addressRepository.save(address);

        AddressResponse response = addressMapper.toAddressResponse(address);

        return GlobalResponse.<Meta, AddressResponse>builder()
                             .meta(Meta.builder().status(Status.SUCCESS).build())
                             .data(response)
                             .build();
    }
}
