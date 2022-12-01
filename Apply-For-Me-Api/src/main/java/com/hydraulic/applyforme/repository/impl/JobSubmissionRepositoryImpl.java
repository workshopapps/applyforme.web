package com.hydraulic.applyforme.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.model.dto.ProfessionalJobSubmissionDTO;
import com.hydraulic.applyforme.repository.JobSubmissionRepository;
import com.hydraulic.applyforme.repository.jpa.ProfessionalJpaRepository;

@Repository
public class JobSubmissionRepositoryImpl implements JobSubmissionRepository {

	final int DEFAULT_PAGE_SIZE = 10;

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private ProfessionalJpaRepository professionalJpaRepository;

	@Override
	public ProfessionalJobSubmissionDTO getAllSubmissionsByPagination(Long professionalId, Integer pageOffset) {

		String queryString = "SELECT sbm FROM Submission sbm WHERE sbm.professional.id = :professional "
				+ "ORDER BY sbm.createdOn DESC";
		Professional professional = professionalJpaRepository.getById(professionalId);
		
		ProfessionalJobSubmissionDTO professionalSubmissionDTO = new ProfessionalJobSubmissionDTO();
		professionalSubmissionDTO.setProfessional(professional);

		TypedQuery<Submission> professionalSubmissions = entityManager.createQuery(queryString,
				Submission.class);
		professionalSubmissions.setParameter("professional", professionalId);

		professionalSubmissions.setFirstResult((pageOffset - 1) * DEFAULT_PAGE_SIZE);
		professionalSubmissions.setMaxResults(DEFAULT_PAGE_SIZE);

		List<Submission> resultList = professionalSubmissions.getResultList();
		professionalSubmissionDTO.setSubmissions(resultList);
		
		return professionalSubmissionDTO;
	}

}
