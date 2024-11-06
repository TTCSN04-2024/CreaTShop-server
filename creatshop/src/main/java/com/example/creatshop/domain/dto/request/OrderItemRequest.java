package com.example.creatshop.domain.dto.request;
/*
 * @author HongAnh
 * @created 06 / 11 / 2024 - 5:49 CH
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderItemRequest {
    Integer productId;
    Integer variantId;
    Integer quantity;
}
