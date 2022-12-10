package com.hydraulic.applyforme.service;

import java.util.List;

import com.hydraulic.applyforme.model.response.JobDescriptionResponse;
import org.springframework.data.domain.Page;

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
import com.hydraulic.applyforme.model.dto.professional.ProfessionalDto;

public interface ProfessionalService {

    List<Professional> findAll(Integer pageOffset);

    Professional findOne(Long id);

    boolean updateProfile(ProfessionalDto professionalDto, Long id);

    Page<Professional> retrieveAllProfessionals(int pageNo, int PageSize);

	List<ProfessionalProfile> findAllJobProfile(Long id);

    JobDescriptionResponse viewJobDescription(Long professionalId, Long submissionId);


}
