package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.Member;
import org.springframework.data.jpa.repository.Query;

public interface ApplicantRepository{
    Member getMyDetailsById(Long id);
}
