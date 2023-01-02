package com.hydraulic.applyforme.model.exception;

public class NotAuthorisedException extends ApplyForMeException{

    private static final long serialVersionUID = 1L;
    private String entityId = null;

    public NotAuthorisedException(String entityId) {
        this.entityId = entityId;
    }

    @Override
    public String getMessage() {
        return String.format("Error occurred while trying to perform action%s", entityId);
    }
}
