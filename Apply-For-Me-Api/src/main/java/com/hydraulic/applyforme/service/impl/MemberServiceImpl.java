package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.Role;
import com.hydraulic.applyforme.model.dto.authentication.SignupDto;
import com.hydraulic.applyforme.model.enums.RoleType;
import com.hydraulic.applyforme.model.exception.EmailAlreadyExistsException;
import com.hydraulic.applyforme.model.exception.MemberNotFoundException;
import com.hydraulic.applyforme.model.exception.RoleNotFoundException;
import com.hydraulic.applyforme.repository.MemberRepository;
import com.hydraulic.applyforme.repository.jpa.MemberJpaRepository;
import com.hydraulic.applyforme.repository.jpa.RoleJpaRepository;
import com.hydraulic.applyforme.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    @Autowired
    private ModelMapper modelMapper;
<<<<<<< HEAD

    private MemberRepository repository;

    private MemberJpaRepository jpaRepository;

=======
    private final MemberJpaRepository memberJpaRepository;
>>>>>>> origin/feat/BE-22-add-applicant-revision
    @Autowired
    private RoleJpaRepository roleJpaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

<<<<<<< HEAD
    public MemberServiceImpl(MemberRepository repository, MemberJpaRepository jpaRepository) {
        this.repository = repository;
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Member findOne(Long id) {
        Member member = repository.getOne(id);
        if (member == null) {
            throw new MemberNotFoundException(id);
        }
        return member;
    }

    @Override
    @Transactional
    public Member save(SignupDto body) {
        boolean existingMember = jpaRepository.existsByEmailAddress(body.getEmailAddress());

=======
    @Override
    @Transactional
    public Member save(SignUpDto body) {
        boolean existingMember = memberJpaRepository.existsByEmailAddress(body.getEmailAddress());
>>>>>>> origin/feat/BE-22-add-applicant-revision
        if (existingMember) {
            throw new EmailAlreadyExistsException();
        }

        Optional<Role> existingRole = roleJpaRepository.findByCode(RoleType.RECRUITER.getValue());

        if (existingRole.isEmpty()) {
            throw new RoleNotFoundException(RoleType.RECRUITER.getValue());
        }

        Member member = new Member();
        member = modelMapper.map(body, Member.class);

        member.addRole(existingRole.get());
<<<<<<< HEAD
        member.setPassword(passwordEncoder.encode(body.getPassword()));

        repository.saveOne(member);
=======
        memberJpaRepository.save(member);
>>>>>>> origin/feat/BE-22-add-applicant-revision
        return member;
    }
}
