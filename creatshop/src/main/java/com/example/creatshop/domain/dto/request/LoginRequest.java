package com.example.creatshop.domain.dto.request;
/*
 * @author HongAnh
 * @created 22 / 09 / 2024 - 4:51 PM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.constant.ErrorMessage;
import com.example.creatshop.constant.Validate;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginRequest {
    @NotEmpty(message = ErrorMessage.Validate.ERR_USERNAME_NOT_BLANK)
    String username;

    @NotEmpty(message = ErrorMessage.Validate.ERR_PASSWORD_NOT_BLANK)
    @Pattern(regexp = Validate.Auth.PASSWORD_PATTERN, message = ErrorMessage.Validate.ERR_PASSWORD_FORMAT)
    String password;
}
