package com.hydraulic.applyforme.service.job;

import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
import com.hydraulic.applyforme.model.dto.professionalprofile.DeleteManyProfessionalProfileDto;
import com.hydraulic.applyforme.model.dto.professionalprofile.ProfessionalProfileDto;

import javax.transaction.Transactional;
import java.util.List;

public interface ProfessionalJobProfileService {


    List<ProfessionalProfile> findAll(Integer pageOffset);

    List<ProfessionalProfile> findAll();

    ProfessionalProfile findOne(Long id);

    @Transactional
    ProfessionalProfile save(ProfessionalProfileDto body);

    @Transactional
    ProfessionalProfile update(Long id, ProfessionalProfileDto body);

    @Transactional
    boolean delete(Long id);

    @Transactional
    boolean deleteMany(DeleteManyProfessionalProfileDto countryDto);

    @Transactional
    boolean deleteAll();
}
