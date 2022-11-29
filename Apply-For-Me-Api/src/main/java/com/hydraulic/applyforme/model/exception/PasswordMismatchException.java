package com.hydraulic.applyforme.model.exception;

public class PasswordMismatchException extends ApplyForMeException {

	@Override
	public String getMessage() {
		return "New password and existing password should match.";
	}

}
