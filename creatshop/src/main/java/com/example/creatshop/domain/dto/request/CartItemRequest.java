package com.example.creatshop.domain.dto.request;
/*
 * @author HongAnh
 * @created 04 / 11 / 2024 - 5:45 CH
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
public class CartItemRequest {
    Integer productId;
    Integer variantId;
    Integer quantity;
}
