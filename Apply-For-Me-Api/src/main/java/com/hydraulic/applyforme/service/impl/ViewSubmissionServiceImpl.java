package com.hydraulic.applyforme.service.impl;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.model.dto.submission.DeleteManySubmissionDto;
import com.hydraulic.applyforme.model.dto.submission.SubmissionDto;
import com.hydraulic.applyforme.model.exception.ViewSubmissionNotFoundException;
import com.hydraulic.applyforme.repository.ViewSubmissionRepository;
import com.hydraulic.applyforme.repository.jpa.ViewSubmissionJpaRepository;
import com.hydraulic.applyforme.service.ViewSubmissionService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class ViewSubmissionServiceImpl implements ViewSubmissionService {
    private final ViewSubmissionJpaRepository viewSubmissionJpaRepository;
    private final ViewSubmissionRepository viewSubmissionRepository;

    @Autowired
    private ModelMapper modelMapper;
    public ViewSubmissionServiceImpl(ViewSubmissionJpaRepository viewSubmissionJpaRepository, ViewSubmissionRepository viewSubmissionRepository) {
        this.viewSubmissionJpaRepository = viewSubmissionJpaRepository;
        this.viewSubmissionRepository = viewSubmissionRepository;
    }

//    @Override
//    public Collection<Submission> getAllApplicationSubmissions() {
//        Collection<Submission> submissions = viewSubmissionJpaRepository.findAll();
//        return submissions;
//
//    }

    @Override
    public void seedSubmissionRecords() throws JsonProcessingException {

    }

    @Override
    public List<Submission> findAll() {
        return viewSubmissionRepository.getAll();
    }

    @Override
    public List<Submission> findAll(Integer pageOffset) {
        return viewSubmissionRepository.getAll(pageOffset);
    }

    @Override
    public Submission findOne(Long id) {
        Submission submission = viewSubmissionRepository.getOne(id);
        if(submission == null){
            throw new ViewSubmissionNotFoundException(id);
        }

        return submission;
    }

    @Override
    @Transactional
    public Submission save(SubmissionDto body) {
        Submission submission = new Submission();
        submission = modelMapper.map(body, Submission.class);
        return viewSubmissionRepository.updateOne(submission);
    }

    @Override
    public Submission update(Long id, SubmissionDto body) {
       Submission existingSubmission = viewSubmissionRepository.getOne(id);
       if(existingSubmission == null){
           throw new ViewSubmissionNotFoundException(id);
       }

       Submission submission = new Submission();
       submission = modelMapper.map(body, Submission.class);
       submission.setId(id);
        return viewSubmissionRepository.updateOne(submission);
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        boolean removed = viewSubmissionRepository.remove(id);
        if(removed){
            return true;
        }else{
            throw new ViewSubmissionNotFoundException(id);
        }

    }

    @Override
    public boolean deleteMany(DeleteManySubmissionDto submissionDto) {
        return viewSubmissionRepository.removeMany(submissionDto.getIds());
    }

    @Override
    public boolean deleteAll() {
        return viewSubmissionRepository.removeAll();
    }
}
