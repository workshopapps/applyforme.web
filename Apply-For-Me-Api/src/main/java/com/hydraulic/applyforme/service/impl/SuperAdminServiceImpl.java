package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.exception.MemberNotFoundException;
import com.hydraulic.applyforme.repository.SuperAdminRepository;
import com.hydraulic.applyforme.repository.jpa.SuperAdminJpaRepository;
import com.hydraulic.applyforme.service.SuperAdminService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class SuperAdminServiceImpl implements SuperAdminService {

    SuperAdminRepository repository;
    SuperAdminJpaRepository jpaRepository;

    public SuperAdminServiceImpl(SuperAdminRepository repository, SuperAdminJpaRepository jpaRepository) {
        this.repository = repository;
        this.jpaRepository = jpaRepository;
    }

    public Member getDetailsById(Long id) {
        Member member = repository.getOneMember(id);
        if (member == null) {
            throw new MemberNotFoundException(id);
        }
       return member;
    }

    @Override
    @Transactional
    public boolean deleteMemberById(Long id) {
        boolean removed = repository.removeMemberById(id);
        if(removed){
            return true;
        }
        else {
            throw new MemberNotFoundException(id);
        }
    }

    @Override
    public Optional<Member> getAdmin(Long id) {
        return jpaRepository.findById(id);
    }

}
