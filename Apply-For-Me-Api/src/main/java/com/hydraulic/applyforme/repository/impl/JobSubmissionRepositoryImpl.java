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

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Submission> getAllSubmissions(Long pID, Integer pageOffset) {
		
		final int DEFAULT_PAGE_SIZE = 10;
		
		String getAllSubmission = "SELECT sbm "
								+ "FROM Submission sbm"
								+ " WHERE sbm.professional = professional"
								+ " ORDER BY sbm.createdOn DESC";
		
		TypedQuery<Submission> allProfessionalSubmissions = entityManager.createQuery(getAllSubmission, Submission.class);
		allProfessionalSubmissions.setParameter("professional", pID);
		
		allProfessionalSubmissions.setFirstResult(pageOffset - 1);
		allProfessionalSubmissions.setMaxResults(DEFAULT_PAGE_SIZE);
		
		return allProfessionalSubmissions.getResultList();
	}

	
	
}
