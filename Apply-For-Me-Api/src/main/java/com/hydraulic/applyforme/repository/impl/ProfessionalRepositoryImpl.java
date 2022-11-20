package com.hydraulic.applyforme.repository.impl;

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.repository.ProfessionalRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ProfessionalRepositoryImpl implements ProfessionalRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Professional getProfessionalByMemberId(Long id) {
        return entityManager.find(Professional.class, id);
    }
}
