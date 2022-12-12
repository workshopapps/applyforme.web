package com.hydraulic.applyforme.model.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpiredJwtToken extends ApplyForMeException {

    private static final long serialVersionUID = 1L;
    public static final String ENTITY_NAME = "User";
    public static String description = "The JWT token has expired, do request for a new one.";

    @Override
    public String getMessage() {
        return String.format(description, ENTITY_NAME);
    }
}
