package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
import com.hydraulic.applyforme.model.dto.professionalProfile.ProfessionalProfileDto;
import com.hydraulic.applyforme.model.enums.EmploymentType;
import com.hydraulic.applyforme.repository.ProfessionalRepository;
import com.hydraulic.applyforme.repository.jpa.MemberJpaRepository;
import com.hydraulic.applyforme.repository.jpa.ProfessionalProfileJpaRepository;
import com.hydraulic.applyforme.service.ProfessionalProfileService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
public class ProfessionalProfileServiceImpl implements ProfessionalProfileService {

    MemberJpaRepository memberJpaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProfessionalRepository professionalRepository;

    ProfessionalProfile professionalProfile;
    ProfessionalProfileJpaRepository professionalProfileJpaRepository;


    @Override
    @Transactional
    public ProfessionalProfile createProfessionalProfile(ProfessionalProfileDto body) {

        professionalProfile = modelMapper.map(body, ProfessionalProfile.class); //model maps everything to entity except id
        //need to find a way to map professional_id in Professional entity to ProfessionalProfile professional_id

        return professionalProfileJpaRepository.save(professionalProfile);

    }
}
