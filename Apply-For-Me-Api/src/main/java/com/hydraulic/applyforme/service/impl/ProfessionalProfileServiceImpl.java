package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
import com.hydraulic.applyforme.model.dto.professionalProfile.ProfessionalProfileDto;
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

    @Autowired
    private ModelMapper modelMapper;

    private final ProfessionalProfileJpaRepository repository;


    public ProfessionalProfileServiceImpl(ProfessionalProfileJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public ProfessionalProfile createProfile(ProfessionalProfileDto body) {

        ProfessionalProfile professionalProfile = new ProfessionalProfile();
        Professional professional = new Professional();

        professionalProfile = modelMapper.map(body, ProfessionalProfile.class);

        professionalProfile.setProfessional(professional);

        return repository.save(professionalProfile);

        professionalProfile.setProfessional(professionalRepository.getByEmail());
    }
}
