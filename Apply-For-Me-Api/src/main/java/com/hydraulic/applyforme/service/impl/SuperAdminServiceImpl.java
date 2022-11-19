package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.exception.MemberNotFoundException;
import com.hydraulic.applyforme.repository.jpa.SuperAdminRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuperAdminServiceImpl{

    SuperAdminRepository repository;

    public SuperAdminServiceImpl(SuperAdminRepository repository) {
        this.repository = repository;
    }

    public Member getDetailsById(Long id) {
        Optional<Member> member = repository.findById(id);
        if(member.isPresent()){
            return member.get();
        }
        throw new MemberNotFoundException(id);


    }

}
