package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.ApplyForMe;
import com.hydraulic.applyforme.model.dto.ApplyForMeDto;
import com.hydraulic.applyforme.model.exception.ApplyForMeNotFoundException;
import com.hydraulic.applyforme.repository.ApplyForMeRepository;
import com.hydraulic.applyforme.service.ApplyForMeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class ApplyForMeServiceImpl implements ApplyForMeService {

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
    public ApplyForMe save(ApplyForMeDto body) {
        ApplyForMe applyForMe = ApplyForMe
                .builder()
                .title(body.getTitle())
                .build();
        return repository.saveOne(applyForMe);
    }

    @Override
    public ApplyForMe update(Long id, ApplyForMeDto body) {
        ApplyForMe applyForMe = ApplyForMe
                .builder()
                .id(id)
                .title(body.getTitle())
                .build();
        return repository.updateOne(applyForMe);
    }

    @Override
    public boolean delete(Long id) {
        ApplyForMe applyForMe = ApplyForMe
                .builder()
                .id(id)
                .build();
        return repository.deleteOne(applyForMe);
    }
}
