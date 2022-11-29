package com.hydraulic.applyforme.model.exception;

public class PrivacyPolicyException extends ApplyForMeException {

    @Override
    public String getMessage() {
        return String.format("You should accept the program privacy policy.");
    }
}
