package com.example.creatshop.util;
/*
 * @author HongAnh
 * @created 20 / 09 / 2024 - 7:27 PM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MessageSourceUtil {
    MessageSource messageSource;

    public String getLocalizedMessage(String message, Object... args){
        return messageSource.getMessage(message, args, LocaleContextHolder.getLocale());
    }
}
