package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.dto.ProfessionalJobSubmissionDTO;

public interface JobSubmissionRepository {

	public ProfessionalJobSubmissionDTO getAllSubmissionsByPagination(Long professionalId, Integer pageOffset);
}
