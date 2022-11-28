package com.hydraulic.applyforme.model.exception;

public class PasswordMismatchException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "OOPS! old and new password does not match.";
	}

	
	
	

}
