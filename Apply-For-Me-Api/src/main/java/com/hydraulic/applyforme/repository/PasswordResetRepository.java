package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.Country;
import com.hydraulic.applyforme.model.domain.PasswordResetTokenEntity;

public interface PasswordResetRepository {
    PasswordResetTokenEntity saveOne(PasswordResetTokenEntity passwordResetTokenEntity);
}
