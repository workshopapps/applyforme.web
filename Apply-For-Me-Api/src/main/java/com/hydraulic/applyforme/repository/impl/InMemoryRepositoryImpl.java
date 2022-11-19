package com.hydraulic.applyforme.repository.impl;

import com.hydraulic.applyforme.repository.InMemoryRepository;
import org.springframework.stereotype.Component;

@Component
public class InMemoryRepositoryImpl implements InMemoryRepository {


    @Override
    public void saveEmailVerificationCode(String email, String verificationCode) {
    }
}
