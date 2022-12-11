package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.model.dto.ProfessionalJobSubmissionDTO;
import com.hydraulic.applyforme.model.dto.submission.ApplierSubmissionDto;

import java.util.List;

public interface JobSubmissionRepository {

	public ProfessionalJobSubmissionDTO getAllSubmissionsByPagination(Long professionalId, Integer pageOffset);
	public List<ApplierSubmissionDto> getSubmissionDetails(Long id);
	public List<Submission> getSubmissionsByProfessionalId(Long professional_id);
}
