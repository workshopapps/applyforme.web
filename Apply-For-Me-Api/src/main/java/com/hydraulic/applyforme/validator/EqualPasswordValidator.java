package com.hydraulic.applyforme.validator;

import com.hydraulic.applyforme.annotation.EqualPassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

public class EqualPasswordValidator implements ConstraintValidator<EqualPassword, Object> {

    private String initialField;
    private String matchField;

    @Override
    public void initialize(EqualPassword password) {
        initialField = password.initialField();
        matchField = password.matchField();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        try {
            Object initialFieldValue = getFieldValue(object, initialField);
            Object matchFieldValue = getFieldValue(object, matchField);
            return initialFieldValue != null && initialFieldValue.equals(matchFieldValue);
        } catch (Exception e) {
            return false;
        }
    }
    private Object getFieldValue(Object object, String fieldName) throws Exception {
        Class<?> clazz = object.getClass();
        Field passwordField = clazz.getDeclaredField(fieldName);
        passwordField.setAccessible(true);
        return passwordField.get(object);
    }
}
