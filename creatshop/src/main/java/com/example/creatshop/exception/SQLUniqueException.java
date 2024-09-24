package com.example.creatshop.exception;
/*
 * @author HongAnh
 * @created 24 / 09 / 2024 - 5:26 PM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SQLUniqueException extends DataIntegrityViolationException {
    String message;
    HttpStatus status;

    public SQLUniqueException(String msg) {
        super(msg);
        message = msg;
        status = HttpStatus.BAD_REQUEST;
    }
}
