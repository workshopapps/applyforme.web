package com.hydraulic.applyforme.validator;

import com.hydraulic.applyforme.annotation.EmploymentTypeAnnotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class EmploymentTypeValidator implements ConstraintValidator<EmploymentTypeAnnotation, CharSequence> {

    private List<String> acceptedValues = new ArrayList<>();

    @Override
    public void initialize(EmploymentTypeAnnotation annotation) {
        for (Enum<?> enumValue : annotation.enumClass().getEnumConstants()) {
            acceptedValues.add(enumValue.toString());
        }
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return acceptedValues.contains(value.toString());
    }
}