package com.example.creatshop.domain.dto.response;
/*
 * @author HongAnh
 * @created 22 / 09 / 2024 - 4:51 PM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AuthResponse {
    String accessToken;
    String type;
    String roles;

    public AuthResponse(String accessToken, String roles) {
        this.accessToken = accessToken;
        this.roles = roles;
        type = "Bearer";
    }
}
