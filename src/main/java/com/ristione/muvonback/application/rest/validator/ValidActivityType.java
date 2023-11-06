package com.ristione.muvonback.application.rest.validator;

import com.ristione.muvonback.domain.entities.activity_type.ActivityTypeEnum;
import jakarta.validation.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ActivityTypeValidator.class)
@ReportAsSingleViolation
public @interface ValidActivityType {
    String message() default "Invalid activity type";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

class ActivityTypeValidator implements ConstraintValidator<ValidActivityType, String> {
    @Override
    public void initialize(ValidActivityType constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        for (ActivityTypeEnum type : ActivityTypeEnum.values()) {
            if (type.name().equals(value)) {
                return true;
            }
        }
        return false;
    }
}
