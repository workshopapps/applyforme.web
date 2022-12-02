package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.admin.UpdatePasswordDto;

public interface SuperAdminService {
    Member updatePassword(Long id, UpdatePasswordDto dto);
    Member getProfileDetails(Long id);

}
