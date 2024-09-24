package com.example.creatshop.exception;
/*
 * @author HongAnh
 * @created 24 / 09 / 2024 - 3:11 PM
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
public class AlreadyExistsException extends RuntimeException {
    String     message;
    HttpStatus status;
    String[]   params;

    public AlreadyExistsException(String message) {
        this.message = message;
        status = HttpStatus.BAD_REQUEST;
    }
}
