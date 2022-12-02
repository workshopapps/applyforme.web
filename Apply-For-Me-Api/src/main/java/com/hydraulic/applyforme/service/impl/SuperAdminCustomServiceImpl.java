package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.model.dto.submission.SubmissionDto;
import com.hydraulic.applyforme.model.response.SubmissionEntriesResponse;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import com.hydraulic.applyforme.repository.jpa.SuperAdminCustomJpaRepository;
import com.hydraulic.applyforme.service.SuperAdminCustomService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

import static com.hydraulic.applyforme.util.ApplyForMeUtil.createPageable;

@Service
public class SuperAdminCustomServiceImpl implements SuperAdminCustomService {
    private SuperAdminCustomJpaRepository repository;
    private final ModelMapper modelMapper;
    public SuperAdminCustomServiceImpl(SuperAdminCustomJpaRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }
    @Override
    @Transactional(readOnly = true)
    public ApplyForMeResponse findAll(int pageNo, int pageSize, String sortBy, String sortDir) {
        Page<Submission> submission = repository.findAll(createPageable(pageNo, pageSize, sortBy, sortDir));
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
}

