package com.hydraulic.applyforme.model.exception;

public class InvalidPasswordResetCodeException extends ApplyForMeException{
    private static final long serialVersionUID = 1L;

    public static final String ENTITY_NAME = "Member";

    @Override
    public String getMessage() {
        return String.format("%s The code entered cannot be found or does not exist in record or is invalid.", ENTITY_NAME);
    }
}
