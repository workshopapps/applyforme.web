package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Member;

public interface SuperAdminService {

    Member getDetailsById(Long id);
    boolean deleteById(Long id);
}
