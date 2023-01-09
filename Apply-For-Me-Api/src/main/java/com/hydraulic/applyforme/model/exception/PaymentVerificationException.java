package com.hydraulic.applyforme.model.exception;

public class PaymentVerificationException extends ApplyForMeException{

    private static final long serialVersionUID = 1L;
    private String entityId = null;

    public PaymentVerificationException(String entityId) {
        this.entityId = entityId;
    }

    @Override
    public String getMessage() {
        return String.format("Error occurred while trying to verify payment %s", entityId);
    }
}
