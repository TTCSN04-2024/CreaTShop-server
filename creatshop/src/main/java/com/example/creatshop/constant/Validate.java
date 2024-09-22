package com.example.creatshop.constant;
/*
 * @author HongAnh
 * @created 22 / 09 / 2024 - 5:05 PM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

public interface Validate {

    interface Auth {

        String PASSWORD_PATTERN     = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[!@#$%^&*()_+=<>?/{}~|-]).{8,16}$";
        String PHONE_NUMBER_PATTERN = "^\\+?\\d{10,15}$";
    }
}
