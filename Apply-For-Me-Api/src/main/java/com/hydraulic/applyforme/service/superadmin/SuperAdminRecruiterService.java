package com.hydraulic.applyforme.service.superadmin;

import com.hydraulic.applyforme.model.domain.Member;

public interface SuperAdminRecruiterService {
    Member searchRecruitersByName(String firstName);

    void deleteRecruiterById(Long id);
}
