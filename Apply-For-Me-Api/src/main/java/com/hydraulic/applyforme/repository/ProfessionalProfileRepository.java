package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.ProfessionalProfile;

import java.util.List;

public interface ProfessionalProfileRepository {
    
    List<ProfessionalProfile> getAll();
    List<ProfessionalProfile> getAll(Integer pageOffset);
    ProfessionalProfile getOne(Long id);
    ProfessionalProfile getRef(Long id);
    ProfessionalProfile saveOne(ProfessionalProfile country);
    ProfessionalProfile updateOne(ProfessionalProfile country);
    boolean remove(Long id);
    boolean removeMany(List<Long> ids);
    boolean removeAll();

    boolean deleteJobProfile(Long id);
}
