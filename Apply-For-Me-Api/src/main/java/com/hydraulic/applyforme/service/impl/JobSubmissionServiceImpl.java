package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.model.dto.submission.SubmissionDto;
import com.hydraulic.applyforme.model.exception.ApplierNotFoundException;
import com.hydraulic.applyforme.model.response.SubmissionResponse;
import com.hydraulic.applyforme.repository.ApplierRepository;
import com.hydraulic.applyforme.repository.ProfessionalRepository;
import com.hydraulic.applyforme.repository.jpa.JobSubmissionRepository;
import com.hydraulic.applyforme.service.JobSubmissionService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class JobSubmissionServiceImpl implements JobSubmissionService {

    private final ApplierRepository applierRepository;
    private final JobSubmissionRepository repository;
    private final ProfessionalRepository professionalRepository;

    private final ModelMapper modelMapper;

    public JobSubmissionServiceImpl(JobSubmissionRepository repository, ApplierRepository applierRepository, ProfessionalRepository professionalRepository, ModelMapper modelMapper) {
        this.applierRepository = applierRepository;
        this.repository = repository;
        this.professionalRepository = professionalRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Long countAllApplierSubmissions(Long id) {
        Applier applier = applierRepository.getOne(id);

        if (applier == null) {
            throw new ApplierNotFoundException(id);
        }
        return repository.countByApplier(id);
    }

    @Override
    public SubmissionResponse getAllJobSubmission(int pageNo, int pageSize, String sortBy, String sortDir) {
        Page<Submission> submission = repository.findAll(createPageable(pageNo, pageSize, sortBy, sortDir));
        return getSubmissionResponse(submission);
    }

    @Override
    public SubmissionResponse filterJobSubmission(int pageNo, int pageSize, String sortBy, String sortDir, String q) {
        Page<Submission> submission = repository.findJobSubmissionBySearch(createPageable(pageNo, pageSize, sortBy, sortDir), q);
        return getSubmissionResponse(submission);
    }

    @Override
    public SubmissionDto getSubmissionDetails(Long professionalId, Long submissionId) {
        Professional applicant = professionalRepository.getOne(professionalId);
        Set<Submission> submissions = applicant.getSubmissions();
        Optional<Submission> optionalSubmission = submissions.stream().filter(submission -> submission.getId().equals(submissionId)).findFirst();
        SubmissionDto submissionToView = new SubmissionDto();
        if(optionalSubmission.isPresent()) {
            modelMapper.map(optionalSubmission,submissionToView) ;
        }
        return submissionToView;
    }

    private SubmissionResponse getSubmissionResponse(Page<Submission> submission) {
        Collection<SubmissionDto> submissions = submission
                .getContent()
                .stream()
                .map(x -> {
                    return modelMapper.map(x, SubmissionDto.class);
                })
                .collect(Collectors.toList());

        SubmissionResponse submissionResponse = new SubmissionResponse();
        submissionResponse.setContent(submissions);
        submissionResponse.setPageNo(submission.getNumber());
        submissionResponse.setPageSize(submission.getSize());
        submissionResponse.setTotalElements(submission.getTotalElements());
        submissionResponse.setTotalPages(submission.getTotalPages());
        submissionResponse.setLast(submission.isLast());
        return submissionResponse;
    }

    private Pageable createPageable(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        return PageRequest.of(pageNo, pageSize);
    }
}
