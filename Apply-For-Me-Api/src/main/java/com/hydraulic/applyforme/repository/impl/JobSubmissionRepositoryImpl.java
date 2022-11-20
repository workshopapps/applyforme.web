package com.hydraulic.applyforme.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.repository.JobSubmissionRepository;

@Repository
public class JobSubmissionRepositoryImpl implements JobSubmissionRepository {

	final int DEFAULT_PAGE_SIZE = 10;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Submission> getAllSubmissionsByPagination(Long id, Integer pageOffset) {

		String getAllSubmission = "SELECT sbm " + "FROM Submission sbm" + " WHERE sbm.professional = 1"
				+ " ORDER BY sbm.createdOn DESC";

		TypedQuery<Submission> submissions = entityManager.createQuery(getAllSubmission,
				Submission.class);
		submissions.setParameter("professional", id);

		submissions.setFirstResult(pageOffset - 1);
		submissions.setMaxResults(DEFAULT_PAGE_SIZE);

		return submissions.getResultList();
	}

	

}
