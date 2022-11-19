package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.signup.SignUpDto;
import com.hydraulic.applyforme.model.exception.EmailExistsException;
import com.hydraulic.applyforme.repository.jpa.MemberJpaRepository;
import com.hydraulic.applyforme.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private ModelMapper modelMapper;

    private final MemberJpaRepository repository;

    private final PasswordEncoder passwordEncoder;

    public MemberServiceImpl(MemberJpaRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public Member createMember(SignUpDto body) {
        boolean existingMember = repository.existsByEmailAddress(body.getEmailAddress());
        if (existingMember) {
            throw new EmailExistsException();
        }
        Member member;
        member = modelMapper.map(body, Member.class);
        member.setPassword(passwordEncoder.encode(body.getPassword()));
        return repository.save(member);
    }
}
