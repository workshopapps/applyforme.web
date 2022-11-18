package com.hydraulic.applyforme.repository;

import org.springframework.stereotype.Component;

@Component
public class InMemoryRepositoryImpl implements InMemoryRepository {


    @Override
    public void saveEmailVerificationCode(String email, String verificationCode) {
    }
}
