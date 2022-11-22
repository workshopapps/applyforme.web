package com.hydraulic.applyforme.model.exception;

public class EmailAlreadyExistsException extends ApplyForMeException{

    private static final long serialVersionUID = 1L;

    public static final String ENTITY_NAME = "Email Address";

    public EmailAlreadyExistsException() {
    }

    @Override
    public String getMessage() {
        return String.format("%s already exists in the record and is not available for use by another user.", ENTITY_NAME);
    }

}
