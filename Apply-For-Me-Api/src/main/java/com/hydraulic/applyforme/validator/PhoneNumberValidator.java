package com.hydraulic.applyforme.validator;

import com.hydraulic.applyforme.annotation.PhoneNumberConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumberConstraint, String> {
    @Override
    public void initialize(PhoneNumberConstraint phoneNumber) {

    }
    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        return phoneNumber != null && phoneNumber.matches("[0-9]+")
                && phoneNumber.length() > 10 && phoneNumber.length() < 15;
    }
}
