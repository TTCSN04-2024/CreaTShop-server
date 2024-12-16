package com.example.creatshop.domain.dto.request;
/*
 * @author HongAnh
 * @created 06 / 11 / 2024 - 5:49 CH
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.constant.ErrorMessage;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderItemRequest {
    @NotNull(message = ErrorMessage.Validate.ERR_PRODUCT_ID_NOT_NULL)
    @Min(value = 1, message = ErrorMessage.Validate.ERR_PRODUCT_ID_MIN)
    Integer productId;

    @NotNull(message = ErrorMessage.Validate.ERR_VARIANT_ID_NOT_NULL)
    @Min(value = 1, message = ErrorMessage.Validate.ERR_VARIANT_ID_MIN)
    Integer variantId;

    @NotNull(message = ErrorMessage.Validate.ERR_QUANTITY_NOT_NULL)
    @Min(value = 1, message = ErrorMessage.Validate.ERR_QUANTITY_MIN)
    Integer quantity;
}
