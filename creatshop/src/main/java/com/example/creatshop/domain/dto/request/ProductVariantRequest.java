package com.example.creatshop.domain.dto.request;
/*
 * @author HongAnh
 * @created 26 / 09 / 2024 - 11:39 AM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductVariantRequest {
    String        color;
    String        size;
    Integer       quantity;
    MultipartFile image;
}
