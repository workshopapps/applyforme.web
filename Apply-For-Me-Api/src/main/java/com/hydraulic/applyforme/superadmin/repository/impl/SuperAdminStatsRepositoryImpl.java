package com.hydraulic.applyforme.superadmin.repository.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.superadmin.repository.SuperAdminStatsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Slf4j
@Repository
public class SuperAdminStatsRepositoryImpl implements SuperAdminStatsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Long getAllSubmissions() {
        String queryText = "select count(submissions) from Submission submissions";
        TypedQuery<Long> allSubmissionsQuery = entityManager.createQuery(queryText, Long.class);
        return allSubmissionsQuery.getSingleResult();
    }

    @Override
    public Long getAllUsers() {
        String queryText = "select count(members) from Member members";
        TypedQuery<Long> allMembersQuery = entityManager.createQuery(queryText, Long.class);
        return allMembersQuery.getSingleResult();
    }
}
