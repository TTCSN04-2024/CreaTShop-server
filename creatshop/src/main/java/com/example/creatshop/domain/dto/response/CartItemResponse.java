package com.example.creatshop.domain.dto.response;
/*
 * @author HongAnh
 * @created 23 / 09 / 2024 - 6:57 PM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartItemResponse {
    Integer                id;
    ProductVariantResponse productDetail;
    ProductResponse        productResponse;
    Integer                quantity;
}
