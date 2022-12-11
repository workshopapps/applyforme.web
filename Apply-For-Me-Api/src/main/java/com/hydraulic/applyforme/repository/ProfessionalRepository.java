package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.Professional;
<<<<<<< HEAD
import com.hydraulic.applyforme.model.dto.applicant.ApplicantJobProfileDto;
import com.hydraulic.applyforme.model.dto.professional.ProfessionalDto;
=======
>>>>>>> d1209ce9e517735fb2e20059e2fb0d05cea48f05

import java.util.List;

public interface ProfessionalRepository {

    Professional getOne(Long id);
    List<Professional> getAll(Integer pageOffset);

    Professional getRef(Long id);

    boolean remove(Long id);

    boolean removeMany(List<Long> ids);

    boolean removeAll();


<<<<<<< HEAD
    int updateProfile(ApplicantJobProfileDto body);
=======
    boolean updateOne(Professional body);

    Professional saveOne(Professional body);

//	List<ProfessionalProfile> getAllJobProfile(Long id, int pageOffset);
>>>>>>> d1209ce9e517735fb2e20059e2fb0d05cea48f05
}
