package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.member.UpdateMemberDto;
import com.hydraulic.applyforme.model.exception.MemberNotFoundException;
import com.hydraulic.applyforme.repository.UpdateMemberRepository;
import com.hydraulic.applyforme.repository.jpa.MemberJpaRepository;
import com.hydraulic.applyforme.service.UpdateMemberService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j
@Service
public class UpdateMemberServiceImpl implements UpdateMemberService {

    @Autowired
    private ModelMapper modelMapper;

    private final UpdateMemberRepository repository;
    private final MemberJpaRepository jpaRepository;

    public UpdateMemberServiceImpl(UpdateMemberRepository repository, MemberJpaRepository jpaRepository) {
        this.repository = repository;
        this.jpaRepository = jpaRepository;
    }

    @Override
    @Transactional
    public Member update(Long id, UpdateMemberDto body) {


        Optional<Member> existingMember = jpaRepository.findById(id);

        if (existingMember == null) {
            throw new MemberNotFoundException(id);
        }

        Member member = new Member();
        member = modelMapper.map(body, Member.class);
        member.setId(id);
        member.setNationality(body.getNationality());
        member.setCountryOfResidence(body.getCountryOfResidence());

        return repository.updateOne(member);

    }

}
