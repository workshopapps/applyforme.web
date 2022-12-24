package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface ProfessionalProfileService {


    ApplyForMeResponse getEntries(int pageNo, int pageSize, String sortBy, String sortDir, String q, Date from, Date to);

    @Transactional(readOnly = true)
    ApplyForMeResponse getUserEntries(int pageNo, int pageSize, String sortBy, String sortDir, String q, Date from, Date to, Long userId);

    ProfessionalProfile findOne(Long id);

    ProfessionalProfile findOne(Long memberId, Long id);
}
