package com.hydraulic.applyforme.model.exception;

public class InvalidOtpException extends ApplyForMeException {

    private static final long serialVersionUID = 1L;
    public static final String ENTITY_NAME = "Apply For Me";

    @Override
    public String getMessage() {
        return String.format("%s OTP code is invalid or has expired or does not exists.", ENTITY_NAME);
    }

}
