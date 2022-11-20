package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.domain.Role;
import com.hydraulic.applyforme.model.dto.professional.ApplicantDto;
import com.hydraulic.applyforme.model.enums.RoleType;
import com.hydraulic.applyforme.model.exception.ApplicantAlreadyExistException;
import com.hydraulic.applyforme.repository.jpa.MemberJpaRepository;
import com.hydraulic.applyforme.repository.jpa.ProfessionalJpaRepository;
import com.hydraulic.applyforme.repository.jpa.RoleJpaRepository;
import com.hydraulic.applyforme.service.ProfessionalService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessionalServiceImpl implements ProfessionalService {

    @Autowired
    private ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private  final ProfessionalJpaRepository jpaRepository;
    private final MemberJpaRepository memberJpaRepository;
    private  final RoleJpaRepository roleJpaRepository;


    @Override
    public String addApplicant(ApplicantDto body) {
        final String RESPONSE = "Applicant successfully saved";
        boolean exist = memberJpaRepository.existsByEmailAddress(body.getEmailAddress());
        Optional<Role> existingRole = roleJpaRepository.findByCode(RoleType.PROFESSIONAL.getValue());
        if (exist)
            throw new ApplicantAlreadyExistException();

        Member member = new Member();
        Professional professional = new Professional();

        member = modelMapper.map(body, Member.class);
        member.setPassword(passwordEncoder.encode(body.getPassword()));
        member.getRoles().add(existingRole.get());

        professional = modelMapper.map(body, Professional.class);
        professional.setMember(member);
        jpaRepository.save(professional);

        return RESPONSE;
    }
}
