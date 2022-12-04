package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
import com.hydraulic.applyforme.model.dto.professionalprofile.DeleteManyProfessionalProfileDto;
import com.hydraulic.applyforme.model.dto.professionalprofile.ProfessionalProfileDto;
import com.hydraulic.applyforme.model.exception.ProfessionalProfileNotFoundException;
import com.hydraulic.applyforme.repository.ProfessionalProfileRepository;
import com.hydraulic.applyforme.repository.jpa.ProfessionalProfileJpaRepository;
import com.hydraulic.applyforme.service.job.ProfessionalJobProfileService;
import com.hydraulic.applyforme.util.ProfessionalProfileUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class ProfessionalJobProfileServiceImpl implements ProfessionalJobProfileService {

    private final ProfessionalProfileRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public ProfessionalJobProfileServiceImpl(ProfessionalProfileRepository repository, ProfessionalProfileJpaRepository jpaRepository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProfessionalProfile> findAll(Integer pageOffset) {
        return repository.getAll(pageOffset);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProfessionalProfile> findAll() {
        return repository.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public ProfessionalProfile findOne(Long id) {
        ProfessionalProfile professionalProfile = repository.getOne(id);
        if (professionalProfile == null) {
            throw new ProfessionalProfileNotFoundException(id);
        }
        return professionalProfile;
    }

    @Override
    @Transactional
    public ProfessionalProfile save(ProfessionalProfileDto body) {
        ProfessionalProfile professionalProfile = new ProfessionalProfile();
        professionalProfile = modelMapper.map(body, ProfessionalProfile.class);

        professionalProfile.setEmploymentType(ProfessionalProfileUtil.getEmploymentType(body.getEmploymentType()));
        professionalProfile.setJobSeniority(ProfessionalProfileUtil.getJobSeniority(body.getJobSeniority()));
        professionalProfile.setPreferredJobLocationType(ProfessionalProfileUtil.getJobLocationType(body.getPreferredJobLocationType()));
        return repository.saveOne(professionalProfile);
    }

    @Override
    @Transactional
    public ProfessionalProfile update(Long id, ProfessionalProfileDto body) {
        ProfessionalProfile existingProfessionalProfile = repository.getOne(id);
        if (existingProfessionalProfile == null) {
            throw new ProfessionalProfileNotFoundException(id);
        }

        ProfessionalProfile professionalProfile = new ProfessionalProfile();
        professionalProfile = modelMapper.map(body, ProfessionalProfile.class);
        professionalProfile.setId(id);
        return repository.updateOne(professionalProfile);
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        boolean removed = repository.remove(id);
        if (removed) {
            return true;
        }
        else {
            throw new ProfessionalProfileNotFoundException(id);
        }
    }

    @Override
    @Transactional
    public boolean deleteMany(DeleteManyProfessionalProfileDto manyDto) {
        return repository.removeMany(manyDto.getIds());
    }

    @Override
    @Transactional
    public boolean deleteAll() {
        return repository.removeAll();
    }
}
