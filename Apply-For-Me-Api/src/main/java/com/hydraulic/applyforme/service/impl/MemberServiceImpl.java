package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Country;
import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.domain.Role;
import com.hydraulic.applyforme.model.dto.authentication.SignupDto;
import com.hydraulic.applyforme.model.dto.member.UpdateMemberDto;
import com.hydraulic.applyforme.model.enums.RoleType;
import com.hydraulic.applyforme.model.exception.EmailAlreadyExistsException;
import com.hydraulic.applyforme.model.exception.MemberNotFoundException;
import com.hydraulic.applyforme.model.exception.RoleNotFoundException;
import com.hydraulic.applyforme.repository.MemberRepository;
import com.hydraulic.applyforme.repository.MemberSecretCodeRepository;
import com.hydraulic.applyforme.repository.ProfessionalRepository;
import com.hydraulic.applyforme.repository.jpa.MemberJpaRepository;
import com.hydraulic.applyforme.repository.jpa.MemberSecretJpaRepository;
import com.hydraulic.applyforme.repository.jpa.RoleJpaRepository;
import com.hydraulic.applyforme.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository repository;
    private final MemberJpaRepository jpaRepository;
    private final MemberSecretCodeRepository memberSecretCodeRepository;

    private final ProfessionalRepository professionalRepository;

    @Autowired
    private RoleJpaRepository roleJpaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    public MemberServiceImpl(MemberRepository repository,
                             MemberJpaRepository jpaRepository,
                             MemberSecretCodeRepository memberSecretJpaRepository,
                             ProfessionalRepository professionalRepository) {
        this.repository = repository;
        this.jpaRepository = jpaRepository;
        this.memberSecretCodeRepository = memberSecretJpaRepository;
        this.professionalRepository = professionalRepository;
    }

    @Override
    @Transactional(readOnly = true)
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

        if (existingMember) {
            throw new EmailAlreadyExistsException();
        }

        Optional<Role> existingRole = roleJpaRepository.findByCode(RoleType.PROFESSIONAL.getValue());

        if (existingRole.isEmpty()) {
            throw new RoleNotFoundException(RoleType.PROFESSIONAL.getValue());
        }

        Member member = new Member();
        member = modelMapper.map(body, Member.class);

        member.addRole(existingRole.get());
        member.setPassword(passwordEncoder.encode(body.getPassword()));

        repository.saveOne(member);
        Professional professional = Professional.builder()
                .member(member)
                .submissions(null)
                .professionalProfiles(null)
                .build();
        professionalRepository.saveOne(professional);

        String generatedSecretCode = generateSignUpCode();
        memberSecretCodeRepository.saveSecretCode(generatedSecretCode);

        return member;
    }


    /*
    * This method helps to generate sign-up verification and was used in the method above
    * to save the sign-up verification code into the DB as shown below.
    * String generatedSecretCode = generateSignUpCode();
       memberSecretCodeRepository.saveSecretCode(generatedSecretCode);
    *
    **/
    private String generateSignUpCode() {
        int[] numbers = new int[4];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 9);
        }
        String code = "" + numbers[0] + numbers[1] + numbers[2] + numbers[3] + "";
        return code;
    }

    @Override
    @Transactional
    public boolean update(Long id, UpdateMemberDto body) {

        Member member = repository.getOne(id);

        if (member == null) {
            throw new MemberNotFoundException(id);
        }
        member = modelMapper.map(body, Member.class);
//        member.setId(id);
        member.setNationality(Country.builder().id(body.getNationality()).build());
        member.setCountryOfResidence(Country.builder().id(body.getCountryOfResidence()).build());
//        jpaRepository.save(member)
        repository.updateOne(member);
        return true;
    }
}
