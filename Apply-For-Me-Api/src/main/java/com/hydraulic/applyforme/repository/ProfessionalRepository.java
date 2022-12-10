package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.domain.ProfessionalProfile;

import java.util.List;

public interface ProfessionalRepository {

    Professional getOne(Long id);
    List<Professional> getAll(Integer pageOffset);

    Professional getRef(Long id);

    boolean remove(Long id);

    boolean removeMany(List<Long> ids);

    boolean removeAll();

    Professional updateOne(Professional body);

	//List<ProfessionalProfile> getAllJobProfile(Long id, int pageOffset);

}
