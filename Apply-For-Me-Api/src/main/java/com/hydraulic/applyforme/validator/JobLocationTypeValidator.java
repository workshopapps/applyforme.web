package com.hydraulic.applyforme.validator;

import com.hydraulic.applyforme.annotation.JobLocationTypeAnnotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class JobLocationTypeValidator implements ConstraintValidator<JobLocationTypeAnnotation, CharSequence> {

    private List<String> acceptedValues = new ArrayList<>();

    @Override
    public void initialize(JobLocationTypeAnnotation annotation) {
        for (Enum<?> enumValue : annotation.enumClass().getEnumConstants()) {
            acceptedValues.add(enumValue.toString());
        }
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return acceptedValues.contains(value.toString().toUpperCase());
    }
}
