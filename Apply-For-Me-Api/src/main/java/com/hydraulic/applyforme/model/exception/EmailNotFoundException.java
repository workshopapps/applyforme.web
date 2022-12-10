package com.hydraulic.applyforme.model.exception;

public class EmailNotFoundException extends ApplyForMeException{
    private static final long serialVersionUID = 1L;
    public static final String ENTITY_NAME = "Email Not Found";

    @Override
    public String getMessage() {
        return String.format("%s The entered does not exist.", ENTITY_NAME);
    }
}
