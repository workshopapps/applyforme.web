package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.UpdatePasswordDTO;

public interface SuperAdminRepository {
    Member  getOneMember(Long id);
    Member updatePassword(Long id, UpdatePasswordDTO newPassword);
}
