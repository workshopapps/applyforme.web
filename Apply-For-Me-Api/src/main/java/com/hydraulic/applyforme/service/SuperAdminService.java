package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.admin.UpdatePasswordDto;
import com.hydraulic.applyforme.model.dto.admin.UpdateProfileDto;

public interface SuperAdminService {

    Member updateProfile(Long id, UpdateProfileDto body);

	Member getDetailsById(Long id);

	boolean deleteMemberById(Long id);

	Member getAdmin(Long id);

	Member updatePassword(Long id, UpdatePasswordDto dto);

	Member getProfileDetails(Long id);
}
