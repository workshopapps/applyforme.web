package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.dto.applicant.ApplicantResponse;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import com.hydraulic.applyforme.repository.jpa.JobSubmissionRepository;
import com.hydraulic.applyforme.service.ApplicantService;
import com.hydraulic.applyforme.util.ApplyForMeUtil;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ApplicantServiceImpl implements ApplicantService {


    private final JobSubmissionRepository jobSubmissionRepository;

    private final ModelMapper modelMapper;

    public ApplicantServiceImpl(JobSubmissionRepository jobSubmissionRepository, ModelMapper modelMapper) {
        this.jobSubmissionRepository = jobSubmissionRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public ApplyForMeResponse getApplicationList(int pageNo, int pageSize, String sortBy, String sortDir) {
        Pageable pageable =  ApplyForMeUtil.createPageable(pageNo, pageSize, sortBy, sortDir);
        var result =  jobSubmissionRepository.findAll(pageable);

        Collection<ApplicantResponse> applicantResponse = result.getContent().stream().map(x -> {
                    Random random = new Random();

                    int randomNumber = random.nextInt(400 - 200) + 200;
                    return  ApplicantResponse.builder()
                            .id(x.getId())
                            .date(x.getCreatedOn())
                            .jobLocation(x.getJobLocation())
                            .jobTitle(x.getJobTitle())
                            .jobType(x.getJobLocationType().getValue())
                            .jobCompany(x.getJobCompany())
                            .salaryRange("$" + randomNumber)
                            .build();

                }
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
