package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.PasswordResetTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PasswordResetTokenJPARepository extends JpaRepository<PasswordResetTokenEntity, String> {
    PasswordResetTokenEntity findPasswordResetTokenEntitiesByOtp(String otp);
}
