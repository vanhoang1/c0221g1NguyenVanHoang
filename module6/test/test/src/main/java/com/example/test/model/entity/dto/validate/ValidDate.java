package com.example.test.model.entity.dto.validate;

import com.example.test.model.entity.dto.PatientDto;
import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.time.temporal.ChronoUnit;

@Documented
@Constraint(validatedBy = DateDifferenceValidator.class)
@Target( { ElementType.FIELD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDate {

    String message() default "The hospital discharge date must be greater than the admission date";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
class DateDifferenceValidator implements ConstraintValidator<ValidDate, PatientDto> {
    @Override
    public boolean isValid(PatientDto value, ConstraintValidatorContext context) {
        long days = ChronoUnit.DAYS.between(value.getHospitalizedDate(), value.getHospitalDischargeDate());
      return  days  > 0;
    }
}