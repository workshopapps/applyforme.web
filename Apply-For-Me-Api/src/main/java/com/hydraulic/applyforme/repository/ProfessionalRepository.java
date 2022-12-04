package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
import com.hydraulic.applyforme.model.dto.professional.ProfessionalDto;
import com.hydraulic.applyforme.model.dto.professional.ProfessionalJobSubmissionDetailsDto;

import java.util.List;

public interface ProfessionalRepository {

    Professional getOne(Long id);
    List<Professional> getAll(Integer pageOffset);

    Professional getRef(Long id);

    boolean remove(Long id);

    boolean removeMany(List<Long> ids);

    boolean removeAll();

    Professional updateProfessional(Professional body);




}
