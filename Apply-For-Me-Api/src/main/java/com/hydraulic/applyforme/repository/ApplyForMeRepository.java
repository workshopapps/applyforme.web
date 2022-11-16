package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.ApplyForMe;

import java.util.List;

public interface ApplyForMeRepository {

    List<ApplyForMe> getAll(Integer pageOffset);

    ApplyForMe getOne(Long id);

    ApplyForMe saveOne(ApplyForMe body);

    ApplyForMe updateOne(ApplyForMe body);

    boolean deleteOne(ApplyForMe body);
}
