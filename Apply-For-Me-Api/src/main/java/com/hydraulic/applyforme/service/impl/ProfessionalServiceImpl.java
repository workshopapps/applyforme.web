package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.repository.ProfessionalRepository;
import com.hydraulic.applyforme.service.ProfessionalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProfessionalServiceImpl implements ProfessionalService {

    private final ProfessionalRepository repository;


    public ProfessionalServiceImpl(ProfessionalRepository repository) {
        this.repository = repository;
    }

    @Override
    //use Professional returned from repo to set professional
    public Professional findProfessionalByMemberId(Long id) {
        Professional professional = repository.getProfessionalByMemberId(id);
        return professional;
    }
}
