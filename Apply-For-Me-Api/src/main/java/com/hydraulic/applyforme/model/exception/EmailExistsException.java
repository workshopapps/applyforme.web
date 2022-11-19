package com.hydraulic.applyforme.model.exception;

import lombok.Getter;
import lombok.Setter;

public class EmailExistsException extends RuntimeException{

    public static final String ENTITY_NAME = "Email Address";

    @Getter
    @Setter
    private Integer code = 500;

    public EmailExistsException() {
    }

    @Override
    public String getMessage() {
        return String.format("%s already exists in the record and is not available for use by " +
                "another user.", ENTITY_NAME);
    }

}
