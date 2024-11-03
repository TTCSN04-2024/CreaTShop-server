package com.example.creatshop.exception;
/*
 * @author HongAnh
 * @created 28 / 09 / 2024 - 11:28 AM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UploadFileException extends RuntimeException {
    String message;
    HttpStatus status;

    public UploadFileException(String message) {
        this.message = message;
        status = HttpStatus.BAD_REQUEST;
    }
}
