package com.hydraulic.applyforme.service;

public interface MemberSecretCodeService {
    public String generateSignUpCode();
    public void sendSignUpVerificationEmail();
}
