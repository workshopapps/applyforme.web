package com.hydraulic.applyforme.model.exception;

public class InvalidResetTokenException extends ApplyForMeException {
    private static final long serialVersionUID = 1L;
    public static final String ENTITY_NAME = "Member";
    private Object entityId = null;
    private Object emailAddress = null;

    public InvalidResetTokenException(Object entityId, Object emailAddress) {
        this.entityId = entityId;
        this.emailAddress = emailAddress;
    }

    @Override
    public String getMessage() {
        return String.format("%s %s with reset token %s cannot be found or does not exist in record or is invalid.", ENTITY_NAME, emailAddress.toString(), entityId.toString());
    }
}
