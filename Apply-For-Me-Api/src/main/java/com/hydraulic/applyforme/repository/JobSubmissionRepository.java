package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.model.dto.ProfessionalJobSubmissionDTO;
import com.hydraulic.applyforme.model.dto.professional.ProfessionalJobSubmissionDetailsDto;

import java.util.List;

public interface JobSubmissionRepository {

	public ProfessionalJobSubmissionDTO getAllSubmissionsByPagination(Long professionalId, Integer pageOffset);

	public List<Submission> getSubmissionDetails(Long id);
}
