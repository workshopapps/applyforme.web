package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Country;
import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.country.CountryDto;
import com.hydraulic.applyforme.model.dto.member.UpdateMemberDto;
import com.hydraulic.applyforme.model.exception.CountryNotFoundException;
import com.hydraulic.applyforme.model.exception.MemberNotFoundException;
import com.hydraulic.applyforme.repository.UpdateMemberRepository;
import com.hydraulic.applyforme.repository.jpa.UpdateMemberJpaRepository;
import com.hydraulic.applyforme.service.UpdateMemberService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
public class UpdateMemberServiceImpl implements UpdateMemberService {

    @Autowired
    private ModelMapper modelMapper;


    private final UpdateMemberRepository repository;
    private final UpdateMemberJpaRepository jpaRepository;

    public UpdateMemberServiceImpl(UpdateMemberRepository repository, UpdateMemberJpaRepository jpaRepository) {
        this.repository = repository;
        this.jpaRepository = jpaRepository;
    }

    @Override
    @Transactional
    public Member update(Long id, UpdateMemberDto body) {

        Member existingMember = repository.getOne(id);

        if (existingMember == null) {
            throw new MemberNotFoundException(id);
        }

        Member member = new Member();
        member = modelMapper.map(body, Member.class);
        member.setId(id);
        return repository.updateOne(member);
    }

}
