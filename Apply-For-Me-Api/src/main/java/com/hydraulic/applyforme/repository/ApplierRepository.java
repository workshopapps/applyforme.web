package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.domain.ApplyForMe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ApplierRepository {

    List<Applier> getAll(Integer pageOffset);

    Applier getOne(Long id);

    Applier saveOne(Applier body);

    Applier updateOne(ApplyForMe body);

    boolean remove(Long id);

    boolean removeMany(List<Long> ids);

    boolean removeAll();

}
