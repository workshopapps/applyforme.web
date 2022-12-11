package com.hydraulic.applyforme.repository;

<<<<<<< HEAD
import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
import com.hydraulic.applyforme.model.dto.applicant.ApplicantJobProfileDto;
=======
import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
>>>>>>> d1209ce9e517735fb2e20059e2fb0d05cea48f05

import java.util.List;

public interface ProfessionalProfileRepository {
<<<<<<< HEAD
    ProfessionalProfile getOne(Long id);
    boolean remove(Long id);
    ProfessionalProfile updateOne(ProfessionalProfile body);
    int updateProfile(ApplicantJobProfileDto body);
=======
    
    List<ProfessionalProfile> getAll();
    List<ProfessionalProfile> getAll(Integer pageOffset);
    ProfessionalProfile getOne(Long id);
    ProfessionalProfile getRef(Long id);
    ProfessionalProfile saveOne(ProfessionalProfile country);
    ProfessionalProfile updateOne(ProfessionalProfile country);
    boolean remove(Long id);
    boolean removeMany(List<Long> ids);
    boolean removeAll();
    List<ProfessionalProfile> findByProfessionalId(Long id);
	boolean deleteById(Long id);
>>>>>>> d1209ce9e517735fb2e20059e2fb0d05cea48f05
}
