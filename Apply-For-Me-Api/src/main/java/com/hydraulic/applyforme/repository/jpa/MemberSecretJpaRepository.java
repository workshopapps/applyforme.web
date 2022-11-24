package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.MemberSecretCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberSecretJpaRepository extends JpaRepository<MemberSecretCode, Long> {

    MemberSecretCode findBySignUpVerificationCode(String signUpVerificationCode);

    MemberSecretCode findByForgotPasswordCode(String forgotPasswordCode);
}
