package com.example.creatshop.domain.dto.request;
/*
 * @author HongAnh
 * @created 24 / 09 / 2024 - 3:01 PM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.constant.ErrorMessage;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryRequest {
    @NotEmpty(message = ErrorMessage.Validate.ERR_CATEGORY_NAME_NOT_EMPTY)
    String name;

    String description;

    @NotEmpty(message = ErrorMessage.Validate.ERR_CATEGORY_TYPE_NOT_EMPTY)
    String type;
}
