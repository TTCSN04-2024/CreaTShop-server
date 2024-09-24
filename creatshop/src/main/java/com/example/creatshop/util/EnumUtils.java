package com.example.creatshop.util;
/*
 * @author HongAnh
 * @created 24 / 09 / 2024 - 3:26 PM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.constant.CategoryType;
import com.example.creatshop.exception.NotFoundException;
import org.springframework.stereotype.Component;

@Component
public class EnumUtils {

    public boolean isValidEnumValue(String value) {
        for (CategoryType type : CategoryType.values()) {
            if (type.name().equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }

    public CategoryType fromString(String value) {
        for (CategoryType type : CategoryType.values()) {
            if (type.name().equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new NotFoundException("No enum constant for value: " + value);
    }
}
