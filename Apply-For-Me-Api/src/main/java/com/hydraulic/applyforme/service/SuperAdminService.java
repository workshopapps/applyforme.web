package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Member;

import javax.transaction.Transactional;
import java.util.Optional;

public interface SuperAdminService {

    Member getDetailsById(Long id);
    boolean deleteMemberById(Long id);
    Member getAdmin(Long id);
}
