package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.TokenEntity;

public interface PasswordResetRepository {
    TokenEntity saveOne(TokenEntity tokenEntity);
}
