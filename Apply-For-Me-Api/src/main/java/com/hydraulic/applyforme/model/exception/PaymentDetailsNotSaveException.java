package com.hydraulic.applyforme.model.exception;

public class PaymentDetailsNotSaveException extends ApplyForMeException{

    private static final long serialVersionUID = 1L;
    private String entityId = null;

    public PaymentDetailsNotSaveException(String entityId) {
        this.entityId = entityId;
    }

    @Override
    public String getMessage() {
        return String.format("Error occurred while trying to save payment details %s", entityId);
    }
}
