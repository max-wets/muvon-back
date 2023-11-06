package com.ristione.muvonback.application.rest.validator;

import com.ristione.muvonback.domain.entities.activity.ActivitySourceType;
import jakarta.validation.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ActivitySourceTypeValidator.class)
@ReportAsSingleViolation
public @interface ValidActivitySourceType {
    String message() default "Invalid activity source type";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

class ActivitySourceTypeValidator implements ConstraintValidator<ValidActivitySourceType, String> {
    @Override
    public void initialize(ValidActivitySourceType constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        for (ActivitySourceType sourceType : ActivitySourceType.values()) {
            if (sourceType.getSource().equals(value)) {
                return true;
            }
        }
        return false;
    }
}
