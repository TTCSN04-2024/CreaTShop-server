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
            String PREFIX             = V1.PREFIX + "/categories";
            String CREATE_CATEGORY    = PREFIX;
            String UPDATE_CATEGORY    = PREFIX + "/{id}";
            String DELETE_CATEGORY    = PREFIX + "/{id}";
            String GET_CATEGORY       = PREFIX;
            String GET_CATEGORY_BY_ID = PREFIX + "/{categoryId}";
        }

        public interface Product {
            String PREFIX            = V1.PREFIX + "/products";
            String CREATE_PRODUCT    = PREFIX;
            String GET_PRODUCT_BY_ID = PREFIX + "/{productId}";
            String GET_PRODUCT       = PREFIX;
            String UPDATE_PRODUCT    = PREFIX + "/{productId}";
            String DELETE_PRODUCT    = PREFIX + "/{productId}";
        }

        public interface Variant {
            String PREFIX                 = V1.PREFIX + "/variants";
            String CREATE_VARIANT         = PREFIX + "/{productId}";
            String GET_VARIANT_BY_PRODUCT = PREFIX + "/product/{productId}";
            String GET_VARIANT            = PREFIX;
            String GET_VARIANT_BY_ID      = PREFIX + "/{variantId}";
            String UPDATE_VARIANT         = PREFIX + "/{variantId}";
            String DELETE_VARIANT         = PREFIX + "/{variantId}";
        }

        public interface Cart {
            String PREFIX              = V1.PREFIX + "/carts";
            String ADD_CART_ITEM       = PREFIX;
            String GET_CART_ITEM       = PREFIX;
            String GET_CART_ITEM_BY_ID = PREFIX + "/{cartItemId}";
            String UPDATE_CART_ITEM    = PREFIX + "/{cartItemId}";
            String DELETE_CART_ITEM    = PREFIX + "/{cartItemId}";
        }

        public interface Address {
            String PREFIX            = V1.PREFIX + "/addresses";
            String ADD_ADDRESS       = PREFIX;
            String GET_ADDRESS       = PREFIX;
            String GET_ADDRESS_BY_ID = PREFIX + "/{addressId}";
            String DELETE_ADDRESS    = PREFIX + "/{addressId}";
            String UPDATE_ADDRESS    = PREFIX + "/{addressId}";
        }
    }
}
