package com.hydraulic.applyforme.model.exception;

public class PhoneNumberAlreadyExistsException extends ApplyForMeException {

    private static final long serialVersionUID = 1L;
    public static final String ENTITY_NAME = "Member";

    @Override
    public String getMessage() {
        return String.format("%s already exists with this phone number in the record and is not available for use by another user.", ENTITY_NAME);
    }
}
