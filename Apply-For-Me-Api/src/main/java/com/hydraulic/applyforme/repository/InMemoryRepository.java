package com.hydraulic.applyforme.repository;

public interface InMemoryRepository {

    public void saveEmailVerificationCode(String email, String verificationCode);
}
