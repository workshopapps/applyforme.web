package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.password.ChangePasswordDto;

public interface ChangePasswordService {

    Member changePassword(Long Id, ChangePasswordDto password);

    boolean checkIfValidOldPassword(Member member, String password);
}
