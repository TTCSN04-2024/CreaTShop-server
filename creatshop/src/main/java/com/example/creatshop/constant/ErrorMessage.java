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

    interface Validate {
        String ERR_USERNAME_NOT_BLANK  = "exception.validate.username.not-blank";
        String ERR_PASSWORD_NOT_BLANK  = "exception.validate.password.not-blank";
        String ERR_PASSWORD_FORMAT     = "exception.validate.password.format";
        String ERR_FIRSTNAME_NOT_BLANK = "exception.validate.firstName.not-blank";
        String ERR_LASTNAME_NOT_BLANK = "exception.validate.lastName.not-blank";
        String ERR_EMAIL_FORMAT       = "exception.validate.email.format";
        String ERR_PHONE_FORMAT       = "exception.validate.phoneNumber.format";
    }

    public interface Role {
        String NOT_FOUND_BY_TYPE = "exception.role.not-found";
    }
}
