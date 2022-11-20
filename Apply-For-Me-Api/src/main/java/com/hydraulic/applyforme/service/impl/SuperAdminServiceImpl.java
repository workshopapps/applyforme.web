package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.exception.MemberNotFoundException;
import com.hydraulic.applyforme.repository.SuperAdminRepository;
import com.hydraulic.applyforme.repository.jpa.SuperAdminJpaRepository;
import com.hydraulic.applyforme.service.SuperAdminService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SuperAdminServiceImpl implements SuperAdminService {

    SuperAdminJpaRepository jpaRepository;
    SuperAdminRepository adminRepo;

    public SuperAdminServiceImpl(SuperAdminJpaRepository jpaRepository, SuperAdminRepository adminRepo) {
        this.jpaRepository = jpaRepository;
        this.adminRepo = adminRepo;
    }

    public Member getDetailsById(Long id) {
        Optional<Member> member = jpaRepository.findById(id);
        if(member.isPresent()){
            return member.get();
        }
        throw new MemberNotFoundException(id);


    }

}
