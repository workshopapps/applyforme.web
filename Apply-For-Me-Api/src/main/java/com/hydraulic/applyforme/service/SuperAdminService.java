package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.UpdatePasswordDTO;

public interface SuperAdminService {

    Member getDetailsById(Long id);

	public void updatePasswordById(Long id, UpdatePasswordDTO updatePasswordDTO);
}
