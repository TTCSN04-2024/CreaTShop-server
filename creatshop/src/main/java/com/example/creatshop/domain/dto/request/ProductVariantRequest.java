package com.example.creatshop.domain.dto.request;
/*
 * @author HongAnh
 * @created 26 / 09 / 2024 - 11:39 AM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "Màu sắc của biến thể sản phẩm", example = "Đỏ")
    String color;

    @Schema(description = "Kích thước của biến thể sản phẩm", example = "L")
    String size;

    @Schema(description = "Số lượng của biến thể sản phẩm", example = "100")
    Integer quantity;

    @Schema(description = "Hình ảnh của biến thể sản phẩm", type = "string", format = "binary")
    MultipartFile image;
}
