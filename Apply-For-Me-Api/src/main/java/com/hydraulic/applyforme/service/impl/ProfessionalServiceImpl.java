package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.model.dto.professional.ProfessionalDto;
import com.hydraulic.applyforme.model.dto.professional.ProfessionalJobSubmissionDetailsDto;
import com.hydraulic.applyforme.model.exception.ProfessionalNotFoundException;
import com.hydraulic.applyforme.repository.JobSubmissionRepository;
import com.hydraulic.applyforme.repository.ProfessionalRepository;
import com.hydraulic.applyforme.service.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessionalServiceImpl implements ProfessionalService {

    @Autowired
    private final ProfessionalRepository repository;

    @Autowired
    private final JobSubmissionRepository jobSubmissionRepository;

    public ProfessionalServiceImpl(ProfessionalRepository repository, JobSubmissionRepository jobSubmissionRepository) {
        this.repository = repository;
        this.jobSubmissionRepository = jobSubmissionRepository;
    }

    @Override
    public List<Professional> findAll(Integer pageOffset) { return repository.getAll(pageOffset); }

    @Override
    @Transactional(readOnly = true)
    public Professional findOne(Long id) {
        Professional professional = repository.getOne(id);
        if (professional == null) {
            throw new ProfessionalNotFoundException(id);
        }
        professional.setSubmissions(null);
        professional.setProfessionalProfiles(null);
        return professional;
    }

    @Override
    @Transactional
    public Professional updateProfessional(ProfessionalDto professionalDto, Long id){
        //UserDetailsImpl userDetails = CurrentUserUtil.getCurrentUser();
        // Long id = userDetails.getId();
        Professional professional = repository.getOne(id);
        if (professional == null) {
            throw new ProfessionalNotFoundException(id);
        }

        System.out.println("Before => professional.isAvailableForInterview(): " + professional.isAvailableForInterview());

        professional.setAvailableForInterview(professionalDto.isAvailableForInterview());

        System.out.println("After => professional.isAvailableForInterview(): " + professionalDto.isAvailableForInterview());

        professional.setLinkedinLink(professionalDto.getLinkedinLink());
        professional.setFacebookLink(professionalDto.getFacebookLink());
        professional.setTwitterLink(professionalDto.getTwitterLink());
        professional.setInstagramLink(professionalDto.getInstagramLink());
        professional.setHobbies(professionalDto.getHobbies());
        professional.setOtherLink1(professionalDto.getOtherLink1());
        professional.setOtherLink2(professionalDto.getOtherLink2());
        professional.setOtherLink3(professionalDto.getOtherLink3());

        professional = repository.updateProfessional(professional);
        return professional;
    }

    @Override
    public List<ProfessionalJobSubmissionDetailsDto> getJobsSubmissionDetails(Long id) {
        List<Submission> listOfJobsSubmitted = jobSubmissionRepository.getSubmissionDetails(id);
        List<ProfessionalJobSubmissionDetailsDto> newlistOfJobsSubmitted= new ArrayList<>();
        for(Submission submission : listOfJobsSubmitted){
            ProfessionalJobSubmissionDetailsDto jobSubmissionDetailsDto = new ProfessionalJobSubmissionDetailsDto();
            jobSubmissionDetailsDto.setJobCompany(submission.getJobCompany());
            jobSubmissionDetailsDto.setCreatedOn(submission.getCreatedOn());
            jobSubmissionDetailsDto.setJobLink(submission.getJobLink());
            jobSubmissionDetailsDto.setJobLocation(submission.getJobLocation());
            jobSubmissionDetailsDto.setJobTitle(submission.getJobTitle());
            jobSubmissionDetailsDto.setOtherComment(submission.getOtherComment());
            jobSubmissionDetailsDto.setSummary(submission.getSummary());
            newlistOfJobsSubmitted.add(jobSubmissionDetailsDto);
        }
        System.out.println("newlistOfJobsSubmitted.size(): " + newlistOfJobsSubmitted.size());
        return newlistOfJobsSubmitted;
    }

}
