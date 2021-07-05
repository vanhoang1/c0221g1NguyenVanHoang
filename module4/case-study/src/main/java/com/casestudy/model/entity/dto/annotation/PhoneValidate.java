package com.casestudy.model.entity.dto.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PhoneValidate implements ConstraintValidator<Phone, String> {
    @Override
    public void initialize(Phone constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Pattern.matches("^(090)\\d{7}$|^(091)\\d{7}$|^(\\(84\\)\\+90)\\d{7}$|^(\\(84\\)\\+91)\\d{7}$",value);
    }
}
