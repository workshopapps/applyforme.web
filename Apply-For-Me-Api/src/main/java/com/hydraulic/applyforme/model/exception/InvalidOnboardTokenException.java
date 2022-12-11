package com.hydraulic.applyforme.model.exception;

public class InvalidOnboardTokenException extends ApplyForMeException {

    @Override
    public String getMessage() {
        return "The token is invalid and can't be used to complete your on-boarding.";
    }

}
