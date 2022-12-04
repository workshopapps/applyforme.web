package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.exception.ProfessionalNotFoundException;
import com.hydraulic.applyforme.repository.ProfessionalRepository;
import com.hydraulic.applyforme.repository.jpa.ProfessionalJpaRepository;
import com.hydraulic.applyforme.service.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfessionalServiceImpl implements ProfessionalService {

    @Autowired
    private final ProfessionalRepository repository;
    private final ProfessionalJpaRepository professionalJpaRepository;
    public ProfessionalServiceImpl(ProfessionalRepository repository, ProfessionalJpaRepository professionalJpaRepository) {
        this.repository = repository;
        this.professionalJpaRepository = professionalJpaRepository;
    }

    @Override
    public List<Professional> findAll(Integer pageOffset) { return repository.getAll(pageOffset); }
    @Override
    @Transactional(readOnly = true)
    public Professional findOne(Long id) {
        Professional professional = repository.getOne(id);
        if (professional == null) {
            throw new ProfessionalNotFoundException(id);
        }
        professional.setSubmissions(null);
        professional.setProfessionalProfiles(null);
        return professional;
    }

    @Override
    public Page<Professional> retrieveAllProfessionals(int pageNo, int pageSize) {
        Pageable page = PageRequest.of(pageNo, pageSize, Sort.Direction.DESC  );
      Page<Professional> applicantsPage = professionalJpaRepository.findAll(page);
      if (applicantsPage.isEmpty()){
          throw new ProfessionalNotFoundException(applicantsPage.getTotalElements());
      }
      return applicantsPage;
    }

}
