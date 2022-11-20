package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.dto.ApplierDto;
import com.hydraulic.applyforme.repository.jpa.ApplierRepo;
import com.hydraulic.applyforme.service.ApplierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ApplierServiceImpl implements ApplierService {

    @Autowired
    private ApplierRepo applierRepo;
    @Autowired
    private ModelMapper modelMapper;

    public List<ApplierDto> getAllAppliers() {

        List<Applier> appliers =this.applierRepo.findAll();
        List<ApplierDto>applierDtos = appliers.stream()
                .map(user->this.applierToDto(user)).collect(Collectors.toList());

        return applierDtos;
    }
    private ApplierDto applierToDto(Applier applier) {

        ApplierDto applierDto = this.modelMapper.map(applier, ApplierDto.class);

        return applierDto;
    }
}
