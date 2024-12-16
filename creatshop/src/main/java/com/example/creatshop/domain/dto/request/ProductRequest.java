package com.example.creatshop.domain.dto.request;
/*
 * @author HongAnh
 * @created 26 / 09 / 2024 - 10:45 AM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "Tên sản phẩm", example = "Giày thể thao")
    String name;

    @Schema(description = "Giá sản phẩm", example = "120.5")
    Double price;

    @Schema(description = "Hình ảnh tĩnh của sản phẩm", type = "string", format = "binary")
    MultipartFile staticImg;

    @Schema(description = "Hình ảnh động của sản phẩm", type = "string", format = "binary")
    MultipartFile dynamicImg;

    @Schema(description = "ID danh mục sản phẩm", example = "1")
    Integer categoryId;
}
