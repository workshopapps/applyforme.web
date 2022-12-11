package com.hydraulic.applyforme.repository.impl;

import com.hydraulic.applyforme.model.domain.TokenEntity;
import com.hydraulic.applyforme.model.exception.PasswordResetEntityDuplicateException;
import com.hydraulic.applyforme.repository.PasswordResetRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Repository
public class PasswordResetRepositoryImpl implements PasswordResetRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public TokenEntity saveOne(TokenEntity tokenEntity){
        try {
            entityManager.persist(tokenEntity);
            return tokenEntity;
        }
        catch (EntityExistsException ex) {
            throw new PasswordResetEntityDuplicateException();
        }
    }
}
