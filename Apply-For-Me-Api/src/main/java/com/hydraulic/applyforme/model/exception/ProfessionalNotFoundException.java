package com.hydraulic.applyforme.model.exception;

public class ProfessionalNotFoundException extends ApplyForMeException {


    private static final long serialVersionUID = 1L;
    public static final String ENTITY_NAME = "Professional";
    private Object entityId = null;

    public ProfessionalNotFoundException(Object entityId) {
        this.entityId = entityId;
    }

    @Override
    public String getMessage() {
        return String.format("%s with an id %s cannot be found or does not exist in record.", ENTITY_NAME, entityId.toString());
    }
}
