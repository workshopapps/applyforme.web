package com.hydraulic.applyforme.model.exception;

public class RoleDuplicateEntityException extends ApplyForMeException {

    private static final long serialVersionUID = 1L;
    public static final String ENTITY_NAME = "Role";

    @Override
    public String getMessage() {
        return String.format("%s entry already exists in record.", ENTITY_NAME);
    }
}
