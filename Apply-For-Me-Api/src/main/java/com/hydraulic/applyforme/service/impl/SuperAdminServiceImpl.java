package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.Role;
import com.hydraulic.applyforme.model.enums.RoleType;
import com.hydraulic.applyforme.model.exception.MemberDuplicateEntityException;
import com.hydraulic.applyforme.model.exception.MemberNotFoundException;
import com.hydraulic.applyforme.repository.SuperAdminRepository;
import com.hydraulic.applyforme.repository.jpa.RoleJpaRepository;
import com.hydraulic.applyforme.repository.jpa.SuperAdminJpaRepository;
import com.hydraulic.applyforme.service.SuperAdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class SuperAdminServiceImpl implements SuperAdminService {

    private SuperAdminRepository repository;
    @Autowired
    private SuperAdminJpaRepository jpaRepository;

    @Autowired
    private  ModelMapper mapper;

    @Autowired
    private RoleJpaRepository roleJpaRepository;

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

    @Override
    @Transactional
    public boolean deleteMemberById(Long id) {
        boolean removed = repository.removeMemberById(id);
        if (removed) {
            return true;
        }
        else {
            throw new MemberNotFoundException(id);
        }
    }

    @Override
    public Member getAdmin(Long id) {
        Member find = repository.viewAdminDetails(id);
        if(find == null){
            throw new MemberNotFoundException(id);
        }
        return find;
    }

}
