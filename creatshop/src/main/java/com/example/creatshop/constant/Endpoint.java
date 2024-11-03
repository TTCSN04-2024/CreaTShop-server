package com.example.creatshop.constant;
/*
 * @author HongAnh
 * @created 22 / 09 / 2024 - 4:54 PM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

public interface Endpoint {

    interface V1 {
        String PREFIX = "/api/v1";

        interface Auth {
            String PREFIX = V1.PREFIX + "/auths";
            String LOGIN  = PREFIX + "/login";
        }

        public interface User {
            String PREFIX      = V1.PREFIX + "/users";
            String CREATE_USER = PREFIX;
            String UPDATE_USER = PREFIX;
            String GET_USER    = PREFIX + "/me";
            String GET_USERS   = PREFIX;
        }

        public interface Category {
            String PREFIX          = V1.PREFIX + "/categories";
            String CREATE_CATEGORY = PREFIX;
            String UPDATE_CATEGORY = PREFIX + "/{id}";
            String DELETE_CATEGORY = PREFIX + "/{id}";
            String GET_CATEGORY    = PREFIX;
        }

        public interface Product {
            String CREATE_PRODUCT = V1.PREFIX + "/products";
        }
    }
}
