package com.hydraulic.applyforme.repository.impl;

import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.repository.SuperAdminStatRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Slf4j
@Repository
public class SuperAdminStatRepositoryImpl implements SuperAdminStatRepository {

    private static final int DEFAULT_PAGE_SIZE = 6;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Long getAllSubmissions() {
        String queryText = "select count(jb) from Submission jb";
        TypedQuery<Long> allSubmissionsQuery = entityManager.createQuery(queryText, Long.class);
        return allSubmissionsQuery.getSingleResult();
    }

    @Override
    public Long getAllUsers() {
        String queryText = "select count(m) from Member m";
        TypedQuery<Long> allMembersQuery = entityManager.createQuery(queryText, Long.class);
        return allMembersQuery.getSingleResult();
    }

    @Override
    public List<Member> getFiniteAppliers(Integer pageOffset) {
        String queryText = "select ap.member from Applier ap";
        TypedQuery<Member> applierTypedQuery = entityManager.createQuery(queryText, Member.class);

        applierTypedQuery.setFirstResult((pageOffset - 1) * DEFAULT_PAGE_SIZE);
        applierTypedQuery.setMaxResults(DEFAULT_PAGE_SIZE);
        return applierTypedQuery.getResultList();
    }
}