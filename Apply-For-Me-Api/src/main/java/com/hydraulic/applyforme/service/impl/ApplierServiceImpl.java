package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.dto.ApplierDto;
import com.hydraulic.applyforme.repository.jpa.ApplierRepo;
import com.hydraulic.applyforme.service.ApplierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplierServiceImpl implements ApplierService {
    @Autowired
    private ApplierRepo repository;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public List<ApplierDto> getAllAppliers() {
        List<Applier> appliers =this.repository.findAll();

        List<ApplierDto> applierDto = appliers.stream()
                .map(user->this.applierToDto(user)).collect(Collectors.toList());
        return applierDto;
    }
    private ApplierDto applierToDto(Applier applier) {

        ApplierDto applierDto = this.modelMapper.map(applier, ApplierDto.class);
        return applierDto;
    }
}
