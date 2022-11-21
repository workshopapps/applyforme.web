package com.hydraulic.applyforme.model.exception;

public class ResetPasswordInvalidTokenException extends ApplyForMeException {

    private static final long serialVersionUID = 1L;
    public static final String ENTITY_NAME = "Reset Password";

    public ResetPasswordInvalidTokenException() {

    }

    @Override
    public String getMessage() {
        return String.format("%s token supplied is invalid.", ENTITY_NAME);
    }

}
