package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.admin.UpdatePasswordDto;
import com.hydraulic.applyforme.model.dto.admin.UpdateProfileDto;

public interface SuperAdminService {
    Member updatePassword(Long id, UpdatePasswordDto dto);
    Member getDetails(Long id);
    Member updateProfile(Long id, UpdateProfileDto body);
}
