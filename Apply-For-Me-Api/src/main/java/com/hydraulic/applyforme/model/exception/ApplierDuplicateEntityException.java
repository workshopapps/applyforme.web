package com.hydraulic.applyforme.model.exception;

public class ApplierDuplicateEntityException extends ApplyForMeException {
    private static final long serialVersionUID = 1L;
    public static final String ENTITY_NAME = "Applier or Reverse Recruiter";

    @Override
    public String getMessage() {
        return String.format("%s entry already exists in record.", ENTITY_NAME);
    }
}
