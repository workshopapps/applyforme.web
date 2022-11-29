package com.hydraulic.applyforme.model.exception;

public class EmailDeliveryException extends ApplyForMeException {

    private static final long serialVersionUID = 1L;
    public static final String ENTITY_NAME = "Emailing";

    @Override
    public String getMessage() {
        return String.format("%s message delivery failed and error has occurred.", ENTITY_NAME);
    }
}
