package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.repository.ApplyForMeRepository;
import com.hydraulic.applyforme.repository.ProfessionalRepository;
import com.hydraulic.applyforme.service.ProfessionalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProfessionalServiceImpl implements ProfessionalService {

    @Autowired
    private final ProfessionalRepository repository;
    public ProfessionalServiceImpl(ProfessionalRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Professional> findAll(Integer pageOffset) { return repository.getAll(pageOffset);}
}
