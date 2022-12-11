package com.hydraulic.applyforme.service.impl;

<<<<<<< HEAD
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
=======

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.dto.applicant.ApplicantDto;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.applicant.ApplicantResponse;
import com.hydraulic.applyforme.model.exception.ProfessionalNotFoundException;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import com.hydraulic.applyforme.repository.ApplicantRepository;
>>>>>>> d1209ce9e517735fb2e20059e2fb0d05cea48f05
import com.hydraulic.applyforme.repository.jpa.JobSubmissionRepository;
import com.hydraulic.applyforme.repository.jpa.ProfessionalRepository;
import com.hydraulic.applyforme.service.ApplicantService;
import com.hydraulic.applyforme.util.ApplyForMeUtil;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ApplicantServiceImpl implements ApplicantService {


    private final JobSubmissionRepository jobSubmissionRepository;
    private final ProfessionalProfileRepository professionalProfileRepository;

    private final ProfessionalRepository professionalRepository;

    private final ModelMapper modelMapper;

<<<<<<< HEAD
    public ApplicantServiceImpl(JobSubmissionRepository jobSubmissionRepository, ProfessionalProfileRepository professionalProfileRepository, ModelMapper modelMapper) {
        this.jobSubmissionRepository = jobSubmissionRepository;
        this.professionalProfileRepository = professionalProfileRepository;
=======

    private final ApplicantRepository repository;

    public ApplicantServiceImpl(JobSubmissionRepository jobSubmissionRepository, ModelMapper modelMapper,
                                ProfessionalRepository professionalRepository,
                                ApplicantRepository repository) {

        this.jobSubmissionRepository = jobSubmissionRepository;
        this.professionalRepository = professionalRepository;
>>>>>>> d1209ce9e517735fb2e20059e2fb0d05cea48f05
        this.modelMapper = modelMapper;
        this.repository = repository;
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


<<<<<<< HEAD
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
=======
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

    @Override
    public Member getDetails(Long id) {
        return repository.getMyDetailsById(id);
    }

>>>>>>> d1209ce9e517735fb2e20059e2fb0d05cea48f05
}
