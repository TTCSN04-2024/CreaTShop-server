package com.example.creatshop.domain.dto.response;
/*
 * @author HongAnh
 * @created 05 / 11 / 2024 - 11:28 CH
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.domain.entity.PaymentDetail;
import com.example.creatshop.domain.entity.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetailResponse {
    Integer id;
    User user;
    PaymentDetail payment;
    Double total;
    Timestamp createdAt;
    Timestamp updatedAt;
    List<OrderItemResponse> orderItems;
}
