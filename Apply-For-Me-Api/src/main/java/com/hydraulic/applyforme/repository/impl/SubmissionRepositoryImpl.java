package com.hydraulic.applyforme.repository.impl;

import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.model.exception.SubmissionDuplicateEntityException;
import com.hydraulic.applyforme.repository.SubmissionRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class SubmissionRepositoryImpl implements SubmissionRepository {


    private static final int DEFAULT_PAGE_SIZE = 11;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Submission saveOne(Submission body) {
        try {
            entityManager.persist(body);
            return body;
        }
        catch (EntityExistsException ex) {
            throw new SubmissionDuplicateEntityException();
        }
    }

}
