package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.model.dto.jobSubmission.JobSubmissionDto;
import com.hydraulic.applyforme.model.dto.submission.ApplierSubmissionDto;
import com.hydraulic.applyforme.model.dto.submission.SubmissionDto;
import com.hydraulic.applyforme.model.exception.ApplierNotFoundException;
import com.hydraulic.applyforme.model.exception.ProfessionalNotFoundException;
import com.hydraulic.applyforme.model.response.SubmissionEntriesResponse;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import com.hydraulic.applyforme.repository.ApplierRepository;
import com.hydraulic.applyforme.repository.jpa.ApplierRepo;
import com.hydraulic.applyforme.repository.jpa.JobSubmissionRepository;
import com.hydraulic.applyforme.repository.jpa.ProfessionalRepository;
import com.hydraulic.applyforme.service.JobSubmissionService;
import com.hydraulic.applyforme.util.CurrentUserUtil;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.hydraulic.applyforme.util.ApplyForMeUtil.createPageable;

@Service
public class JobSubmissionServiceImpl implements JobSubmissionService {

    private final ApplierRepository applierRepository;
    private final JobSubmissionRepository repository;

    private final ApplierRepo applierRepo;

    private final ProfessionalRepository professionalRepository;

    private final com.hydraulic.applyforme.repository.JobSubmissionRepository repo;
    private final ModelMapper modelMapper;

    public JobSubmissionServiceImpl(JobSubmissionRepository repository, ApplierRepository applierRepository,
                                    ApplierRepo applierRepo, ProfessionalRepository professionalRepository, com.hydraulic.applyforme.repository.JobSubmissionRepository repo, ModelMapper modelMapper) {
        this.applierRepository = applierRepository;
        this.repository = repository;
        this.applierRepo = applierRepo;
        this.professionalRepository = professionalRepository;

        this.repo = repo;
        this.modelMapper = modelMapper;
        
    }

    @Override
    public String saveJobSubmission(Long id, JobSubmissionDto jobSubmissionDto) {
//        String newId= CurrentUserUtil.getCurrentUser().getEmailAddress();
//        System.out.println(CurrentUserUtil.getCurrentUser().getId());
//        System.out.println(currentUser);
//        assert currentUser != null;

//        Applier recruiter = applierRepo.findApplierByMemberEmailAddress("jerrybaker1@gmail.com");
        Professional applicant = professionalRepository.findById(id).orElseThrow(() -> new ProfessionalNotFoundException("Professional Not Found"));
        jobSubmissionDto.setApplicantsName(applicant.getMember().getFirstName()+ " " + applicant.getMember().getLastName());

        Submission submission = new Submission();
//        submission.setApplier(recruiter);
        submission.setProfessional(applicant);
        submission.setJobCompany(jobSubmissionDto.getCompanyName());
        submission.setJobTitle(jobSubmissionDto.getJobRole());

        repository.save(submission);
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Long countAllApplierSubmissions(Long id) {
        Applier applier = applierRepository.getOne(id);

        if (applier == null) {
            throw new ApplierNotFoundException(id);
        }
        return repository.countByApplier(id);
    }


    @Override
    @Transactional(readOnly = true)
    public ApplyForMeResponse getAllJobSubmission(int pageNo, int pageSize, String sortBy, String sortDir) {
        Page<Submission> submission = repository.findAll(createPageable(pageNo, pageSize, sortBy, sortDir));
        return getSubmissionResponse(submission);
    }

    @Override
    public ApplyForMeResponse filterJobSubmission(int pageNo, int pageSize, String sortBy, String sortDir, String q) {
        Page<Submission> submission = repository.findJobSubmissionBySearch(createPageable(pageNo, pageSize, sortBy, sortDir), q);
        return getSubmissionResponse(submission);
    }

    private ApplyForMeResponse getSubmissionResponse(Page<Submission> submission) {
        Collection<SubmissionDto> submissions = submission
                .getContent()
                .stream()
                .map(x -> {
                    return modelMapper.map(x, SubmissionDto.class);
                })
                .collect(Collectors.toList());

        SubmissionEntriesResponse response = new SubmissionEntriesResponse();
        response.setPageNo(submission.getNumber());
        response.setContent(submissions);
        response.setPageSize(submission.getSize());
        response.setTotalElements(submission.getTotalElements());
        response.setTotalPages(submission.getTotalPages());
        response.setLast(submission.isLast());
        return response;
    }

    public List<ApplierSubmissionDto> getApplierSubmissionDetails(Long id) {
        List<ApplierSubmissionDto> applierSubmissionDtos = repo.getSubmissionDetails(id);
        return applierSubmissionDtos;
    }
}
