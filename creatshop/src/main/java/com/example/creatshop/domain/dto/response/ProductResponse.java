package com.example.creatshop.domain.dto.response;
/*
 * @author HongAnh
 * @created 23 / 09 / 2024 - 6:59 PM
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
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {
    Integer                      id;
    String                       name;
    Double                       price;
    String                       imageStaticUrl;
    String                       imageDynamicUrl;
    List<ProductVariantResponse> variants;
}
