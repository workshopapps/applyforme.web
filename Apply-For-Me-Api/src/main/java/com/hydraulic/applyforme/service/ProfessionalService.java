package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
import com.hydraulic.applyforme.model.dto.professional.ProfessionalDto;

import org.springframework.data.domain.Page;


import java.util.List;

public interface ProfessionalService {

    List<Professional> findAll(Integer pageOffset);

    Professional findOne(Long id);

    Professional updateProfile(ProfessionalDto professionalDto, Long id);

    Page<Professional> retrieveAllProfessionals(int pageNo, int PageSize);

	List<ProfessionalProfile> findAllJobProfile(Long id, int pageOffset);

}
