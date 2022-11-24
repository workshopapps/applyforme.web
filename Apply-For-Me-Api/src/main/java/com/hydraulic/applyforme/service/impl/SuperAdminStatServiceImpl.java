package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.ApplierStatsDto;
import com.hydraulic.applyforme.repository.SuperAdminStatRepository;
import com.hydraulic.applyforme.service.SuperAdminStatService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SuperAdminStatServiceImpl implements SuperAdminStatService {


    private final SuperAdminStatRepository repository;

    private final ModelMapper mapper;

    public SuperAdminStatServiceImpl(SuperAdminStatRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Long getTotalApplications() {
        return repository.getAllSubmissions();
    }

    @Override
    public Long getTotalUsers() {
        return repository.getAllUsers();
    }

    @Override
    public List<ApplierStatsDto> getAppliers(Integer pageOffset) {

        List<ApplierStatsDto> applierStatsDtos;
        List<Member> appliers = repository.getFiniteAppliers(pageOffset);
        if (appliers.isEmpty()) {
            return null;
        } else {
            applierStatsDtos = appliers.stream().map(applier -> mapper.map(applier, ApplierStatsDto.class))
                    .collect(Collectors.toList());
        }
        return applierStatsDtos;
    }

}
