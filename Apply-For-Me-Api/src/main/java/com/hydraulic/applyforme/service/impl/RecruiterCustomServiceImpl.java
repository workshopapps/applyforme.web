package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.dto.applicant.ApplicantResponse;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import com.hydraulic.applyforme.repository.jpa.JobSubmissionRepository;
import com.hydraulic.applyforme.service.ApplicantService;
import com.hydraulic.applyforme.service.RecruiterCustomService;
import com.hydraulic.applyforme.util.ApplyForMeUtil;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class RecruiterCustomServiceImpl implements RecruiterCustomService {


    private final JobSubmissionRepository jobSubmissionRepository;

    private final ModelMapper modelMapper;

    public RecruiterCustomServiceImpl(JobSubmissionRepository jobSubmissionRepository, ModelMapper modelMapper) {
        this.jobSubmissionRepository = jobSubmissionRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public ApplyForMeResponse getList(int pageNo, int pageSize, String sortBy, String sortDir) {
        Pageable pageable =  ApplyForMeUtil.createPageable(pageNo, pageSize, sortBy, sortDir);
        var result =  jobSubmissionRepository.findAll(pageable);

        Collection<ApplicantResponse> applicantResponse = result.getContent().stream().map(x -> ApplicantResponse.builder()
                .id(x.getId())
                .date(x.getCreatedOn())
                .jobLocation(x.getJobLocation())
                .jobTitle(x.getJobTitle())
                .jobType(x.getJobLocationType().getValue())
                .jobCompany(x.getJobCompany())
                .salaryRange("I don't know where to find it, I can't even do a join table")
                .build()
        ).collect(Collectors.toList());
        ApplyForMeResponse applyForMeResponse = new ApplyForMeResponse();
        applyForMeResponse.setContent(applicantResponse);
        applyForMeResponse.setPageSize(result.getSize());
        applyForMeResponse.setTotalElements(result.getTotalElements());
        applyForMeResponse.setPageNo(result.getNumber());
        applyForMeResponse.setTotalPages(result.getTotalPages());
        applyForMeResponse.setLast(result.isLast());
        return applyForMeResponse;
    }
}