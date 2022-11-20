package com.hydraulic.applyforme.repository.impl;

import com.hydraulic.applyforme.model.domain.Country;
import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.repository.jpa.SubmissionRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class SubmissionRepositoryImpl implements SubmissionRepository {

    private static final int DEFAULT_PAGE_SIZE = 11;
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Submission> getAll(Integer pageOffSet) {
        String queryText = "select c from Submission c order by c.updatedOn desc";
        TypedQuery<Submission> applyForMeQuery = entityManager.createQuery(queryText, Submission.class);

        applyForMeQuery.setFirstResult((pageOffSet- 1) * DEFAULT_PAGE_SIZE);
        applyForMeQuery.setMaxResults(DEFAULT_PAGE_SIZE);
        return applyForMeQuery.getResultList();
    }
}
