package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.dto.professional.ProfessionalDto;
import com.hydraulic.applyforme.model.dto.professional.ProfessionalJobSubmissionDetailsDto;

import java.util.List;

public interface ProfessionalService {

    List<Professional> findAll(Integer pageOffset);

    Professional findOne(Long id);

    Professional updateProfessional(ProfessionalDto professionalDto, Long id);

    List<ProfessionalJobSubmissionDetailsDto> getJobsSubmissionDetails(Long id);
}
