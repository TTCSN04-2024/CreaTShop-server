package com.example.creatshop.domain.dto.request;
/*
 * @author HongAnh
 * @created 05 / 11 / 2024 - 11:28 CH
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderRequest {
    Integer paymentId;
    List<OrderItemRequest> orderItems;
}
