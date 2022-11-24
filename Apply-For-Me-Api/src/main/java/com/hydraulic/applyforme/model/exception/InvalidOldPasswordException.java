package com.hydraulic.applyforme.model.exception;

public class InvalidOldPasswordException extends ApplyForMeException{

    private static final long serialVersionUID = 1L;
    public static final String ENTITY_NAME = "Password";

    @Override
    public String getMessage() {
        return String.format("%s entry does not match old password.", ENTITY_NAME);
    }
}
