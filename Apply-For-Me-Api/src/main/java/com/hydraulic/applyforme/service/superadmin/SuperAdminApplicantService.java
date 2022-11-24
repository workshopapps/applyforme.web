package com.hydraulic.applyforme.service.superadmin;

import com.hydraulic.applyforme.model.dto.country.DeleteManyCountryDto;
import com.hydraulic.applyforme.model.dto.professional.DeleteManyProfessionalDto;

import javax.transaction.Transactional;

public interface SuperAdminApplicantService {

    @Transactional
    boolean delete(Long id);

    @Transactional
    boolean deleteMany(DeleteManyProfessionalDto manyDto);

    @Transactional
    boolean deleteAll();
}
