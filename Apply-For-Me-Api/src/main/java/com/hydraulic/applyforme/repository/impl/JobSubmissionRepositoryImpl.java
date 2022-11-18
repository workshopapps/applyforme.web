package com.hydraulic.applyforme.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.repository.JobSubmissionRepository;

public class JobSubmissionRepositoryImpl implements JobSubmissionRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Submission> getAll(Long pID, Integer pageOffset) {
		
		final int DEFAULT_PAGE_SIZE = 5;
		
		String getAllSubmission = "SELECT sbm "
								+ "FROM Submission sbm"
								+ " WHERE sbm.professional = professional";
		
		TypedQuery<Submission> allProfessionalSubmissions = entityManager.createQuery(getAllSubmission, Submission.class);
		allProfessionalSubmissions.setParameter("professional", pID);
		
		allProfessionalSubmissions.setFirstResult((pageOffset - 1) * DEFAULT_PAGE_SIZE);
		allProfessionalSubmissions.setMaxResults(DEFAULT_PAGE_SIZE);
		
		return allProfessionalSubmissions.getResultList();
	}

	
	
}
