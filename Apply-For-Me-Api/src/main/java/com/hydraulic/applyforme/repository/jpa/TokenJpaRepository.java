package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TokenJpaRepository extends JpaRepository<TokenEntity, Long> {
    TokenEntity findTokenEntityByOtp(String otp);
    TokenEntity findTokenEntitiesByOtpIgnoreCase(String otp);

}
