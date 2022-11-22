package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.exception.MemberNotFoundException;
import com.hydraulic.applyforme.repository.SuperAdminRepository;
import com.hydraulic.applyforme.service.SuperAdminService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SuperAdminServiceImpl implements SuperAdminService {

    SuperAdminRepository repository;

    public SuperAdminServiceImpl(SuperAdminRepository repository) {
        this.repository = repository;
    }

    public Member getDetailsById(Long id) {
        Member member = repository.getOneMember(id);
        if (member == null) {
            throw new MemberNotFoundException(id);
        }
       return member;
    }

}