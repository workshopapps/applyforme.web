package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.ApplyForMe;
import com.hydraulic.applyforme.model.dto.applyforme.ApplyForMeDto;
import com.hydraulic.applyforme.model.dto.applyforme.DeleteManyApplyForMeDto;

import javax.transaction.Transactional;
import java.util.List;

public interface ApplyForMeService {

    List<ApplyForMe> findAll(Integer pageOffset);

    ApplyForMe findOne(Long id);

    ApplyForMe save(ApplyForMeDto body);

    ApplyForMe update(Long id, ApplyForMeDto body);

    boolean delete(Long id);

    @Transactional
    boolean deleteMany(DeleteManyApplyForMeDto manyDto);

    @Transactional
    boolean deleteAll();
}
