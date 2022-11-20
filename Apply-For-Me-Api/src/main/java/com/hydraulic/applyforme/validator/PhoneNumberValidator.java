package com.hydraulic.applyforme.validator;

import com.hydraulic.applyforme.annotation.PhoneNumberConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumberConstraint, String> {
    @Override
    public void initialize(PhoneNumberConstraint phoneNumber) {

    }

    @Override
    public boolean isValid(String contactField, ConstraintValidatorContext context) {
        return contactField != null && contactField.matches("[0-9]+")
                && (contactField.length() > 10) && (contactField.length() < 15);
    }
}
