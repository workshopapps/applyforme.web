package com.hydraulic.applyforme.repository.impl;

import com.hydraulic.applyforme.model.domain.ApplyForMe;
import com.hydraulic.applyforme.repository.ApplyForMeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
@Slf4j
@Repository
public class ApplyForMeRepositoryImpl implements ApplyForMeRepository {

    @Override
    public List<ApplyForMe> getAll() {
        return null;
    }

    @Override
    public ApplyForMe getOne(Long id) {
        return null;
    }

    @Override
    public ApplyForMe saveOne(ApplyForMe body) {
        return null;
    }

    @Override
    public ApplyForMe updateOne(ApplyForMe body) {
        return null;
    }

    @Override
    public boolean deleteOne(ApplyForMe body) {
        return false;
    }
}
