package com.example.creatshop.domain.dto.response;
/*
 * @author HongAnh
 * @created 06 / 11 / 2024 - 7:05 CH
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentResponse {
    Integer   id;
    Double    amount;
    String    provider;
    String    status;
    Timestamp createdAt;
    Timestamp updatedAt;
}
