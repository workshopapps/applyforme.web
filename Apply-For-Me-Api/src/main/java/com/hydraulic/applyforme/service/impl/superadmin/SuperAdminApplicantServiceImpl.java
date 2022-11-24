package com.hydraulic.applyforme.service.impl.superadmin;

import com.hydraulic.applyforme.model.dto.country.DeleteManyCountryDto;
import com.hydraulic.applyforme.model.dto.professional.DeleteManyProfessionalDto;
import com.hydraulic.applyforme.model.exception.CountryNotFoundException;
import com.hydraulic.applyforme.model.exception.ProfessionalNotFoundException;
import com.hydraulic.applyforme.repository.ProfessionalRepository;
import com.hydraulic.applyforme.service.superadmin.SuperAdminApplicantService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class SuperAdminApplicantServiceImpl implements SuperAdminApplicantService {

    private ProfessionalRepository repository;

    public SuperAdminApplicantServiceImpl(ProfessionalRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        boolean removed = repository.remove(id);
        if (removed) {
            return true;
        }
        else {
            throw new ProfessionalNotFoundException(id);
        }
    }

    @Override
    @Transactional
    public boolean deleteMany(DeleteManyProfessionalDto manyDto) {
        return repository.removeMany(manyDto.getIds());
    }

    @Override
    @Transactional
    public boolean deleteAll() {
        return repository.removeAll();
    }
}
