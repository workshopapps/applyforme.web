package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.exception.MemberNotFoundException;
import com.hydraulic.applyforme.repository.SuperAdminRepository;
import com.hydraulic.applyforme.service.SuperAdminService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SuperAdminServiceImpl implements SuperAdminService {

    SuperAdminRepository adminRepo;

    public SuperAdminServiceImpl(SuperAdminRepository adminRepo) {
        this.adminRepo = adminRepo;
    }

    public Member getDetailsById(Long id) {
        Member member = adminRepo.getOneMember(id);
        if(member == null){
            throw new MemberNotFoundException(id);
        }
       return member;
    }

}
