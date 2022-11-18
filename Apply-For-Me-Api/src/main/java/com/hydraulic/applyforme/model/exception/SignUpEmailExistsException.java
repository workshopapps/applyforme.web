package com.hydraulic.applyforme.model.exception;

public class SignUpEmailExistsException extends SignUpException{

    private static final long serialVersionUID = 1L;

    private Integer code = 400;
    private Object entityEmail;

    public SignUpEmailExistsException(Object entityEmail) {
        this.entityEmail = entityEmail;
    }

    @Override
    public String getMessage() {
        return String.format("%s already exists in our records. Please log in with your details", entityEmail);
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
