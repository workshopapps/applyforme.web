package com.hydraulic.applyforme.service.impl;
	
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.model.exception.ApplierNotFoundException;
import com.hydraulic.applyforme.repository.ApplierRepository;
import com.hydraulic.applyforme.repository.jpa.JobSubmissionRepository;
import com.hydraulic.applyforme.service.JobSubmissionService;

@Service
public class JobSubmissionServiceImpl implements JobSubmissionService {

    private final ApplierRepository applierRepository;
    private final JobSubmissionRepository repository;
    private final com.hydraulic.applyforme.repository.JobSubmissionRepository repo;

    public JobSubmissionServiceImpl(JobSubmissionRepository repository, ApplierRepository applierRepository, 
    		com.hydraulic.applyforme.repository.JobSubmissionRepository repo) {
        this.applierRepository = applierRepository;
        this.repository = repository;
        this.repo = repo;
    }

    @Override
    public Long countAllSubmissions(Long id) {
        Optional<Applier> applier = Optional.ofNullable(applierRepository.getOne(id));

        if (applier.isEmpty()) {
            throw new ApplierNotFoundException(id);
        }

        if (applier.isPresent()) {
            return repository.countByApplier(id);
        }
        return 0L;
    }

	@Override
	public List<Submission> getAllSubmissionsByPagination(Long professionalId, Integer pageOffset) {
		
		return repo.getAllSubmissionsByPagination(professionalId, pageOffset);
	}
}
