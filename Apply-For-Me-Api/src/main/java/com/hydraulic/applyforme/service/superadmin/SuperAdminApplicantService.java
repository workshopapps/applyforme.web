package com.hydraulic.applyforme.service.superadmin;

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.dto.professional.DeleteManyProfessionalDto;

import javax.transaction.Transactional;

public interface SuperAdminApplicantService {

    Professional findOne(Long id);

    @Transactional
    boolean delete(Long id);

    @Transactional
    boolean deleteMany(DeleteManyProfessionalDto manyDto);

    @Transactional
    boolean deleteAll();
}
