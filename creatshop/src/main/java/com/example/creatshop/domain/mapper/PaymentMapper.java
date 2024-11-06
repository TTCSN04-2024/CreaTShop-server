package com.example.creatshop.domain.mapper;
/*
 * @author HongAnh
 * @created 06 / 11 / 2024 - 7:34 CH
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.domain.dto.request.PaymentRequest;
import com.example.creatshop.domain.dto.response.PaymentResponse;
import com.example.creatshop.domain.entity.PaymentDetail;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PaymentMapper {
    PaymentResponse toPaymentResponse(PaymentDetail paymentDetail);

    PaymentDetail toPayment(PaymentRequest request);
}
