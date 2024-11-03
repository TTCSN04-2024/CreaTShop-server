package com.example.creatshop.domain.dto.request;
/*
 * @author HongAnh
 * @created 26 / 09 / 2024 - 10:45 AM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequest {
    String                      name;
    Double                      price;
    MultipartFile               staticImg;
    MultipartFile               dynamicImg;
    Integer                     categoryId;
}
