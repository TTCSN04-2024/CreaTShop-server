package com.example.creatshop.exception;
/*
 * @author HongAnh
 * @created 04 / 11 / 2024 - 6:19 CH
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class AuthenticationException extends RuntimeException {
    String     message;
    HttpStatus status;
    String[]   params;

    public AuthenticationException(String message) {
        this.message = message;
        status = HttpStatus.FORBIDDEN;
    }
}
