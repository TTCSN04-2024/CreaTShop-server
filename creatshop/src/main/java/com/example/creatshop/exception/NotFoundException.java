package com.example.creatshop.exception;
/*
 * @author HongAnh
 * @created 22 / 09 / 2024 - 8:03 PM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class NotFoundException extends RuntimeException {
    String message;
    HttpStatus status;
    String[] params;

    public NotFoundException(String message) {
        this.message = message;
        status = HttpStatus.BAD_REQUEST;
    }
}
