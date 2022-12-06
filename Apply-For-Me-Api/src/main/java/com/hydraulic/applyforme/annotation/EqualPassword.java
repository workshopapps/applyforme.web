package com.hydraulic.applyforme.annotation;

import com.hydraulic.applyforme.validator.EqualPasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EqualPasswordValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface EqualPassword {

    String message() default "Initial password and confirmation password should be valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String initialField();

    String matchField();

}
