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
        String ERR_USERNAME_NOT_BLANK      = "exception.validate.username.not-blank";
        String ERR_PASSWORD_NOT_BLANK      = "exception.validate.password.not-blank";
        String ERR_PASSWORD_FORMAT         = "exception.validate.password.format";
        String ERR_FIRSTNAME_NOT_BLANK     = "exception.validate.firstName.not-blank";
        String ERR_LASTNAME_NOT_BLANK      = "exception.validate.lastName.not-blank";
        String ERR_EMAIL_FORMAT            = "exception.validate.email.format";
        String ERR_PHONE_FORMAT            = "exception.validate.phoneNumber.format";
        String ERR_CATEGORY_NAME_NOT_EMPTY = "exception.validate.category.name-not-empty";
        String ERR_CATEGORY_TYPE_NOT_EMPTY = "exception.validate.category.type-not-empty";
    }

    public interface Role {
        String NOT_FOUND_BY_TYPE = "exception.role.not-found";
    }

    public interface User {
        String ERR_NOT_FOUND_USERNAME      = "exception.user.not-found-username";
        String ERR_CAN_NOT_UPDATE_USERNAME = "exception.user.not-update-username";
    }

    public interface Category {
        String EXISTS_BY_NAME  = "exception.category.exist-by-name";
        String NOT_FOUND_TYPE  = "exception.category.not-found-type";
        String NOT_FOUND_BY_ID = "exception.category.not-found-id";
    }

    public interface Common {
        String ALREADY_EXIST_NAME = "exception.common.exist-by-name";
        String NOT_FOUND_CATEGORY = "exception.common.not-found-category";
    }

    public interface Product {
        String ERR_FILE_UPLOAD         = "exception.product.file-format";
        String NOT_FOUND_BY_ID         = "exception.product.not-found-by-id";
        String ERR_NOT_CONTAIN_VARIANT = "exception.product.not-contain-variant";
    }

    public interface ProductVariant {
        String NOT_FOUND_BY_ID = "exception.variant.not-found-by-id";
    }

    public interface CartItem {
        String ERR_QUANTITY_COUNT      = "exception.cart-item.quantity-count";
        String ERR_NOT_FOUND_BY_ID     = "exception.cart-item.not-found-by-id";
        String ERR_NOT_FOUND_CART_ITEM = "exception.cart-item.not-found";
    }
}
