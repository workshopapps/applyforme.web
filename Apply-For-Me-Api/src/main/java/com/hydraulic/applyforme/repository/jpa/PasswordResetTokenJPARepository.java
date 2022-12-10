package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PasswordResetTokenJPARepository extends JpaRepository<TokenEntity, String> {
    TokenEntity findByOtp(String otp);

}
