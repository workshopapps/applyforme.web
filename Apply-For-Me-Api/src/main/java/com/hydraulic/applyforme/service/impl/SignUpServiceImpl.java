package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.CreateAccountDto;
import com.hydraulic.applyforme.model.exception.SignUpEmailExistsException;
import com.hydraulic.applyforme.repository.jpa.MemberJaRepository;
import com.hydraulic.applyforme.service.SignUpService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private ModelMapper modelMapper;

    private MemberJaRepository repository;

    private PasswordEncoder passwordEncoder;

    public SignUpServiceImpl(MemberJaRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public Member signUp(CreateAccountDto body) {
        boolean existingMember = repository.existsByEmailAddress(body.getEmailAddress());
        if (existingMember) {
            throw new SignUpEmailExistsException(body.getEmailAddress());
        }
        Member member = new Member();
        member = modelMapper.map(body, Member.class);
        member.setPassword(passwordEncoder.encode(body.getPassword()));
        return repository.save(member);
    }
}
