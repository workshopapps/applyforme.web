package com.hydraulic.applyforme.service.superadmin;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.dto.professional.DeleteManyProfessionalDto;
import com.hydraulic.applyforme.model.response.ApplicantDetailsResponse;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;

import javax.transaction.Transactional;
import java.util.Date;

public interface SuperAdminApplicantService {

    @Transactional
    boolean delete(Long id);

    @Transactional
    boolean deleteMany(DeleteManyProfessionalDto manyDto);

    @Transactional
    boolean deleteAll();

    ApplyForMeResponse getEntries(int pageNo, int pageSize, String sortBy, String sortDir, String q, Date from, Date to);

    ApplicantDetailsResponse getOne(Long id);
}
