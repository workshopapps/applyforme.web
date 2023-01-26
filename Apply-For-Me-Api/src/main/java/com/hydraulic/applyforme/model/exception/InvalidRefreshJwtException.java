package com.hydraulic.applyforme.model.exception;

import com.hydraulic.applyforme.controller.exception.ErrorResponseConstant;

public class InvalidRefreshJwtException extends ApplyForMeException {

    private static final long serialVersionUID = 1L;


    @Override
    public String getMessage() {
        return String.format("Invalid Refresh JWT");
    }
}
