package com.hydraulic.applyforme.repository.impl;

import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.response.ApplierJobSubmissionStatistics;
import com.hydraulic.applyforme.model.response.ApplierJobSubmissionTotalResponse;
import com.hydraulic.applyforme.repository.ApplierRepository;
import com.hydraulic.applyforme.repository.MemberRepository;
import com.hydraulic.applyforme.repository.SuperAdminStatRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class SuperAdminStatRepositoryImpl implements SuperAdminStatRepository {
    @PersistenceContext
    private EntityManager entityManager;

    private ApplierRepository applierRepository;

    public SuperAdminStatRepositoryImpl(ApplierRepository applierRepository) {
        this.applierRepository = applierRepository;
    }
    @Override
    public Long getAllSubmissions() {
        String queryText = "select count(jb) from Submission jb";
        TypedQuery<Long> total = entityManager.createQuery(queryText, Long.class);
        return total.getSingleResult();
    }
    @Override
    public Long getAllUsers() {
        String queryText = "select count(m) from Member m";
        TypedQuery<Long> total = entityManager.createQuery(queryText, Long.class);
        return total.getSingleResult();
    }

    @Override
    public List<ApplierJobSubmissionStatistics> getAppliersTotalSubmissions() {
        String queryText = "select applier_id, count(*) AS total from job_submission group by applier_id order by total DESC";
        List<Object[]> stats = entityManager.createNativeQuery(queryText).setMaxResults(10).getResultList();

        List<ApplierJobSubmissionTotalResponse> submissions = new ArrayList<>();
        List<ApplierJobSubmissionStatistics> statistics = new ArrayList<>();

        for (Object[] stat: stats) {
            ApplierJobSubmissionTotalResponse response = new ApplierJobSubmissionTotalResponse();
            response.setApplierId(((BigInteger) stat[0]).longValue());
            response.setTotal(((BigInteger) stat[1]).longValue());
            submissions.add(response);

            ApplierJobSubmissionStatistics applierStatistics = setApplierJobSubmissionStatistics(response);
            statistics.add(applierStatistics);
        }
        return statistics;
    }

    private ApplierJobSubmissionStatistics setApplierJobSubmissionStatistics(ApplierJobSubmissionTotalResponse response) {
        Applier applier = applierRepository.getOne(response.getApplierId());
        applier.setSubmissions(null);

        ApplierJobSubmissionStatistics applierStatistics = new ApplierJobSubmissionStatistics();
        applierStatistics.setApplier(applier);
        applierStatistics.setTotal(response.getTotal());
        applierStatistics.setApplierId(response.getApplierId());

        return applierStatistics;
    }

}