package com.casestudy.model.entity.dto.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneValidate.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Phone {
    String message() default "Invalid Phone Number 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
