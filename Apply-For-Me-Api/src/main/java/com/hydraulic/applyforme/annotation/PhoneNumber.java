package com.hydraulic.applyforme.annotation;

import com.hydraulic.applyforme.validator.PhoneNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
@Target( {ElementType.FIELD, ElementType.METHOD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumber {
    String message() default "Phone number should be length's should be between 10 and 15 characters";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
