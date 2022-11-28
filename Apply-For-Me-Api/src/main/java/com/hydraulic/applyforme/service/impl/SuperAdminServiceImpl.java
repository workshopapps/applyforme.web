package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.Role;
import com.hydraulic.applyforme.model.dto.superadmin.MemberDto;
import com.hydraulic.applyforme.model.enums.RoleType;
import com.hydraulic.applyforme.model.exception.MemberDuplicateEntityException;
import com.hydraulic.applyforme.model.exception.MemberNotFoundException;
import com.hydraulic.applyforme.repository.SuperAdminRepository;
import com.hydraulic.applyforme.repository.jpa.RoleJpaRepository;
import com.hydraulic.applyforme.repository.jpa.SuperAdminJpaRepository;
import com.hydraulic.applyforme.service.SuperAdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
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

    @Override
    public List<Member> viewAllRecruiters() {
        return repository.getAllMembers();
    }


    @Override
    public Member createRecruiter(MemberDto memberDto) {

        Optional<Role> existingRole = roleJpaRepository.findByCode(RoleType.RECRUITER.getValue());

        Member member = jpaRepository.findMemberByRoles(existingRole);
        if(member==null){
            Member newMember = mapper.map(memberDto,Member.class);
            return repository.saveOne(newMember);
        }
        throw new MemberDuplicateEntityException();
    }





}
