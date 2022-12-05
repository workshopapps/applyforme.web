package com.hydraulic.applyforme.validator;

import com.hydraulic.applyforme.annotation.PhoneNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
    @Override
    public void initialize(PhoneNumber phoneNumber) {

    }
    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        return phoneNumber != null && phoneNumber.matches("[0-9]+")
                && phoneNumber.length() > 10 && phoneNumber.length() < 15;
    }
}
