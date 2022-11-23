package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.MemberSecretCode;

public interface MemberSecretCodeRepository {
    public MemberSecretCode findBySignUpVerificationCode(String signUpVerificationCode);
}
