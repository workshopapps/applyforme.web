package com.hydraulic.applyforme.model.exception;

public class InvalidOnboardTokenException extends ApplyForMeException {

    private static final long serialVersionUID = 1L;
    public static final String ENTITY_NAME = "Member";
    private Object token = null;

    public InvalidOnboardTokenException(Object token) {
        this.token = token;
    }

    @Override
    public String getMessage() {
        return "The token is invalid and can't be used to complete your on-boarding.";
    }

}
