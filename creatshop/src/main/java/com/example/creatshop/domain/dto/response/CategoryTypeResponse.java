package com.example.creatshop.domain.dto.response;
/*
 * @author HongAnh
 * @created 24 / 09 / 2024 - 6:08 PM
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
public class CategoryTypeResponse {
    String type;
    List<CategoryResponse> categories;
}
