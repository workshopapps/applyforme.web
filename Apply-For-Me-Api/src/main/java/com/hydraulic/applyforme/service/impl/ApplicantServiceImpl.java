package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
import com.hydraulic.applyforme.model.dto.applicant.ApplicantJobProfileDto;
import com.hydraulic.applyforme.model.dto.applicant.ApplicantResponse;
import com.hydraulic.applyforme.model.dto.professional.ProfessionalDto;
import com.hydraulic.applyforme.model.enums.EmploymentType;
import com.hydraulic.applyforme.model.enums.JobLocationType;
import com.hydraulic.applyforme.model.enums.JobSeniority;
import com.hydraulic.applyforme.model.exception.ProfessionalNotFoundException;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import com.hydraulic.applyforme.repository.ProfessionalProfileRepository;
import com.hydraulic.applyforme.repository.jpa.JobSubmissionRepository;
import com.hydraulic.applyforme.service.ApplicantService;
import com.hydraulic.applyforme.util.ApplyForMeUtil;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ApplicantServiceImpl implements ApplicantService {


    private final JobSubmissionRepository jobSubmissionRepository;
    private final ProfessionalProfileRepository professionalProfileRepository;

    private final ModelMapper modelMapper;

    public ApplicantServiceImpl(JobSubmissionRepository jobSubmissionRepository, ProfessionalProfileRepository professionalProfileRepository, ModelMapper modelMapper) {
        this.jobSubmissionRepository = jobSubmissionRepository;
        this.professionalProfileRepository = professionalProfileRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public ApplyForMeResponse getApplicationList(int pageNo, int pageSize, String sortBy, String sortDir) {
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


    @Override
    @Transactional
    public ApplicantJobProfileDto updateJobProfile(ApplicantJobProfileDto applicantJobProfileDto, Long id){
        ProfessionalProfile professionalProfile = professionalProfileRepository.getOne(id);
        if (professionalProfile == null) {
            throw new ProfessionalNotFoundException(id);
        }
        //System.out.println("Before => professionalProfile.isAvailableForInterview(): " + applicantJobProfileDto.isAvailableForInterview());

        professionalProfile.setOtherComment(applicantJobProfileDto.getOtherComment());
        professionalProfile.setOtherSkills(applicantJobProfileDto.getOtherSkills());
        professionalProfile.setCover_letter(applicantJobProfileDto.getCover_letter());
        professionalProfile.setMainProfile(applicantJobProfileDto.getMainProfile());
        professionalProfile.setProfileTitle(applicantJobProfileDto.getProfileTitle());
        professionalProfile.setYearsOfExperience(applicantJobProfileDto.getYearsOfExperience());
        JobLocationType jobLocationType =JobLocationType.valueOf(applicantJobProfileDto.getPreferredJobLocationType());
        professionalProfile.setPreferredJobLocationType(jobLocationType);
        professionalProfile.setSalaryRange(applicantJobProfileDto.getSalaryRange());
        professionalProfile.setResumeLink(applicantJobProfileDto.getResumeLink());
        professionalProfile.setPassportLink(applicantJobProfileDto.getPassportLink());
        JobSeniority jobSeniority = JobSeniority.valueOf(applicantJobProfileDto.getJobSeniority());
        professionalProfile.setJobSeniority(jobSeniority);
        professionalProfile.setJobLocation(applicantJobProfileDto.getJobLocation());
        professionalProfile.setIncludedKeywords(applicantJobProfileDto.getIncludedKeywords());
        EmploymentType employmentType = EmploymentType.valueOf(applicantJobProfileDto.getEmploymentType());
        professionalProfile.setEmploymentType(employmentType);
        professionalProfile.setIndustry(applicantJobProfileDto.getIndustry());
        professionalProfile.setDesiredJobTitle(applicantJobProfileDto.getDesiredJobTitle());
        professionalProfile.setUpdatedOn(applicantJobProfileDto.getUpdatedOn());

        professionalProfile = professionalProfileRepository.updateOne(professionalProfile);
        applicantJobProfileDto = new ApplicantJobProfileDto();

        applicantJobProfileDto.setOtherComment(professionalProfile.getOtherComment());
        applicantJobProfileDto.setOtherSkills(professionalProfile.getOtherSkills());
        applicantJobProfileDto.setCover_letter(professionalProfile.getCover_letter());
        applicantJobProfileDto.setMainProfile(professionalProfile.getMainProfile());
        applicantJobProfileDto.setProfileTitle(professionalProfile.getProfileTitle());
        applicantJobProfileDto.setYearsOfExperience(professionalProfile.getYearsOfExperience());
        applicantJobProfileDto.setPreferredJobLocationType(professionalProfile.getPreferredJobLocationType().getValue());
        applicantJobProfileDto.setSalaryRange(professionalProfile.getSalaryRange());
        applicantJobProfileDto.setResumeLink(professionalProfile.getResumeLink());
        applicantJobProfileDto.setPassportLink(professionalProfile.getPassportLink());
        applicantJobProfileDto.setJobSeniority(professionalProfile.getJobSeniority().getValue());
        applicantJobProfileDto.setJobLocation(professionalProfile.getJobLocation());
        applicantJobProfileDto.setIncludedKeywords(professionalProfile.getIncludedKeywords());
        applicantJobProfileDto.setEmploymentType(professionalProfile.getEmploymentType().getValue());
        applicantJobProfileDto.setIndustry(professionalProfile.getIndustry());
        applicantJobProfileDto.setDesiredJobTitle(professionalProfile.getDesiredJobTitle());
        applicantJobProfileDto.setUpdatedOn(professionalProfile.getUpdatedOn());
        return applicantJobProfileDto;
    }

    @Override
    public ApplicantJobProfileDto updateProfessionalJobProfile(ApplicantJobProfileDto body, Long id){
        int rowsUpdated = professionalProfileRepository.updateProfile(body);
        ProfessionalProfile professionalProfile = professionalProfileRepository.getOne(id);
        if (professionalProfile == null) {
            throw new ProfessionalNotFoundException(id);
        }

        ApplicantJobProfileDto applicantJobProfileDto = null;
        if (rowsUpdated > 0) {
            applicantJobProfileDto = new ApplicantJobProfileDto();

            applicantJobProfileDto.setOtherComment(professionalProfile.getOtherComment());
            applicantJobProfileDto.setOtherSkills(professionalProfile.getOtherSkills());
            applicantJobProfileDto.setCover_letter(professionalProfile.getCover_letter());
            applicantJobProfileDto.setMainProfile(professionalProfile.getMainProfile());
            applicantJobProfileDto.setProfileTitle(professionalProfile.getProfileTitle());
            applicantJobProfileDto.setYearsOfExperience(professionalProfile.getYearsOfExperience());
            applicantJobProfileDto.setPreferredJobLocationType(professionalProfile.getPreferredJobLocationType().getValue());
            applicantJobProfileDto.setSalaryRange(professionalProfile.getSalaryRange());
            applicantJobProfileDto.setResumeLink(professionalProfile.getResumeLink());
            applicantJobProfileDto.setPassportLink(professionalProfile.getPassportLink());
            applicantJobProfileDto.setJobSeniority(professionalProfile.getJobSeniority().getValue());
            applicantJobProfileDto.setJobLocation(professionalProfile.getJobLocation());
            applicantJobProfileDto.setIncludedKeywords(professionalProfile.getIncludedKeywords());
            applicantJobProfileDto.setEmploymentType(professionalProfile.getEmploymentType().getValue());
            applicantJobProfileDto.setIndustry(professionalProfile.getIndustry());
            applicantJobProfileDto.setDesiredJobTitle(professionalProfile.getDesiredJobTitle());
            applicantJobProfileDto.setUpdatedOn(professionalProfile.getUpdatedOn());            
        }
        return applicantJobProfileDto;
    }
}
