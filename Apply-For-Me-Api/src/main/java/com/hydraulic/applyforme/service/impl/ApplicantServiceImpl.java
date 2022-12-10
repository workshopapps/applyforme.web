package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.dto.applicant.ApplicantDto;
import com.hydraulic.applyforme.model.dto.applicant.ApplicantResponse;
import com.hydraulic.applyforme.model.exception.ProfessionalNotFoundException;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import com.hydraulic.applyforme.repository.jpa.JobSubmissionRepository;
import com.hydraulic.applyforme.repository.jpa.ProfessionalRepository;
import com.hydraulic.applyforme.service.ApplicantService;
import com.hydraulic.applyforme.util.ApplyForMeUtil;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ApplicantServiceImpl implements ApplicantService {


    private final JobSubmissionRepository jobSubmissionRepository;

    private final ProfessionalRepository professionalRepository;

    private final ModelMapper modelMapper;

    public ApplicantServiceImpl(JobSubmissionRepository jobSubmissionRepository, ProfessionalRepository professionalRepository, ModelMapper modelMapper) {
        this.jobSubmissionRepository = jobSubmissionRepository;
        this.professionalRepository = professionalRepository;
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

    @Transactional
    @Override
    public Professional update(Long id, ApplicantDto applicantDto) {
        Professional professional = professionalRepository.findById(id).orElseThrow(() -> new ProfessionalNotFoundException("" +
                "Professional Not Found"));

        if (applicantDto.getEmailAddress() != null) {
            professional.getMember().setEmailAddress(applicantDto.getEmailAddress());
        }

        if (applicantDto.getFirstName() != null) {
            professional.getMember().setFirstName(applicantDto.getFirstName());
        }

        if (applicantDto.getLastName() != null) {
            professional.getMember().setLastName(applicantDto.getLastName());
        }

        if (applicantDto.getUsername() != null) {
            professional.getMember().setUsername(applicantDto.getUsername());
        }

        if (applicantDto.getPhoneNumber() != null) {
            professional.getMember().setPhoneNumber(applicantDto.getPhoneNumber());
        }
        return professionalRepository.save(professional);
    }
}
