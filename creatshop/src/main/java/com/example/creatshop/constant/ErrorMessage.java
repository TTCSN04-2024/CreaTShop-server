package com.example.creatshop.constant;
/*
 * @author HongAnh
 * @created 20 / 09 / 2024 - 7:14 PM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

public interface ErrorMessage {

    interface Path {
        String WRONG_PATH = "exception.path.wrong";
    }

    interface Auth {
        String ERR_INVALID_TOKEN     = "exception.auth.invalid-token";
        String ERR_EXPIRED_SESSION   = "exception.auth.expired-session";
        String ERR_UNSUPPORTED_TOKEN = "exception.auth.unsupported-token";
        String ERR_INVALID_SIGNATURE = "exception.auth.invalid.signature";
        String ERR_NOT_LOGIN         = "exception.auth.not-login";
        String ERR_MISSING_PREFIX    = "exception.auth.missing-prefix";
        String ERR_FORBIDDEN         = "exception.auth.forbidden";
    }
}
