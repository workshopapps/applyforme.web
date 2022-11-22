package com.hydraulic.applyforme.model.exception;

public class MemberNotFoundException extends ApplyForMeException {
    private static final long serialVersionUID = 1L;
    public static final String ENTITY_NAME = "Member";
    private Object entityId = null;

    public MemberNotFoundException(Object entityId) {
        this.entityId = entityId;
    }

    @Override
    public String getMessage() {
        return String.format("%s with an id %s cannot be found or does not exist in record.", ENTITY_NAME, entityId.toString());
    }
}
