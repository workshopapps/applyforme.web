package com.hydraulic.applyforme.controller.exception;

public class ErrorResponseConstant {

    public static final String expiredJwt = "The JWT token has expired, do request for a new one.";
    public static final String malformedJwt = "The JWT token is invalid";
    public static final String invalidJwt = "The JWT has an invalid signature";

}
