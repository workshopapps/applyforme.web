package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.dto.ApplierDto;
import com.hydraulic.applyforme.model.response.Response;
import com.hydraulic.applyforme.repository.jpa.ApplierRepo;
import com.hydraulic.applyforme.service.ApplierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplierServiceImpl implements ApplierService {
    @Autowired
    private ApplierRepo repository;
    @Autowired
    private ModelMapper modelMapper;

    public List<ApplierDto> getAllAppliers() {
        List<Applier> appliers =this.repository.findAll();

        List<ApplierDto> applierDto = appliers.stream()
                .map(user->this.applierToDto(user)).collect(Collectors.toList());
        return applierDto;
    }

    @Override
    public Response getApplicants(int pageNo, int pageSize, String q) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Applier> submission =  repository.getStuffs(pageable,q);
        Response submissionResponse = new Response();
        submissionResponse.setContent(submission.getContent());
        submissionResponse.setPageNo(submission.getNumber());
        submissionResponse.setPageSize(submission.getSize());
        submissionResponse.setTotalElements(submission.getTotalElements());
        submissionResponse.setTotalPages(submission.getTotalPages());
        submissionResponse.setLast(submission.isLast());
        return submissionResponse;
    }

    private ApplierDto applierToDto(Applier applier) {

        ApplierDto applierDto = this.modelMapper.map(applier, ApplierDto.class);
        return applierDto;
    }
}
