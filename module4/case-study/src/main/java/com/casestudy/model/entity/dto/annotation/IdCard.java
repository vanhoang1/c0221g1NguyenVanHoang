package com.casestudy.model.entity.dto.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IdCardValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface IdCard {
    String message() default "Invalid  Id Card ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
