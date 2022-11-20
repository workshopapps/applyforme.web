package com.hydraulic.applyforme.model.exception;

public class ApplicantAlreadyExistException extends ApplyForMeException {
    private static final long serialVersionUID = 1L;
    public static final String ENTITY_NAME = "Applicant";

    public ApplicantAlreadyExistException(){}

    @Override
    public String getMessage(){
       return String.format("%s with this details already exist in record", ENTITY_NAME);
    }
}
