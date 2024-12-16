package com.example.creatshop.valid;

import com.cloudinary.utils.StringUtils;
import com.example.creatshop.constant.ErrorMessage;
import com.example.creatshop.constant.Validate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * ----------------------------------------------------------------------------
 * Author:        Hong Anh
 * Created on:    16/12/2024 at 2:56 PM
 * Project:       CreaTShop-server
 * Contact:       https://github.com/lehonganh0201
 * ----------------------------------------------------------------------------
 */

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {


    private static final String PHONE_NUMBER_PATTERN = Validate.Auth.PHONE_NUMBER_PATTERN;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isBlank(value)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorMessage.Validate.ERR_PHONE_NUMBER_NOT_BLANK)
                    .addConstraintViolation();
            return false;
        }

        if (!value.matches(PHONE_NUMBER_PATTERN)) {
            context.buildConstraintViolationWithTemplate(ErrorMessage.Validate.ERR_PHONE_FORMAT)
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}