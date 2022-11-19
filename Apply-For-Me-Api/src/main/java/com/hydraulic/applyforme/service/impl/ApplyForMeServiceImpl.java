package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.ApplyForMe;
import com.hydraulic.applyforme.model.dto.ApplyForMeDto;
import com.hydraulic.applyforme.model.dto.DeleteManyApplyForMeDto;
import com.hydraulic.applyforme.model.exception.ApplyForMeNotFoundException;
import com.hydraulic.applyforme.repository.ApplyForMeRepository;
import com.hydraulic.applyforme.service.ApplyForMeService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Slf4j
@Service
public class ApplyForMeServiceImpl implements ApplyForMeService {

    @Autowired
    private ModelMapper modelMapper;
    private final ApplyForMeRepository repository;


    public ApplyForMeServiceImpl(ApplyForMeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ApplyForMe> findAll(Integer pageOffset) {
        return repository.getAll(pageOffset);
    }

    @Override
    public ApplyForMe findOne(Long id) {
        ApplyForMe applyForMe = repository.getOne(id);
        if (applyForMe == null) {
            throw new ApplyForMeNotFoundException(id);
        }
        return applyForMe;
    }

    @Override
    @Transactional
    public ApplyForMe save(ApplyForMeDto body) {
        ApplyForMe applyForMe = new ApplyForMe();
        applyForMe = modelMapper.map(body, ApplyForMe.class);
        return repository.updateOne(applyForMe);
    }

    @Override
    @Transactional
    public ApplyForMe update(Long id, ApplyForMeDto body) {
        ApplyForMe existingApplyForMe = repository.getOne(id);
        if (existingApplyForMe == null) {
            throw new ApplyForMeNotFoundException(id);
        }

        ApplyForMe applyForMe = new ApplyForMe();
        applyForMe = modelMapper.map(body, ApplyForMe.class);
        applyForMe.setId(id);
        return repository.updateOne(applyForMe);
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        boolean removed = repository.remove(id);
        if (removed) {
            return true;
        }
        else {
            throw new ApplyForMeNotFoundException(id);
        }
    }

    @Override
    @Transactional
    public boolean deleteMany(DeleteManyApplyForMeDto applyForMeDto) {
        return repository.removeMany(applyForMeDto.getIds());
    }

    @Override
    @Transactional
    public boolean deleteAll() {
        return repository.removeAll();
    }
}
