package com.hydraulic.applyforme.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.model.dto.submission.DeleteManySubmissionDto;
import com.hydraulic.applyforme.model.dto.submission.SubmissionDto;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.transaction.Transactional;
import java.util.List;

public interface ViewSubmissionService {
//    Collection<Submission> getAllApplicationSubmissions();

    @Transactional
    @EventListener(ApplicationReadyEvent.class)
    void seedSubmissionRecords() throws JsonProcessingException;

    List<Submission> findAll();

    List<Submission> findAll(Integer pageOffset);

    Submission findOne(Long id);

    @Transactional
    Submission save(SubmissionDto body);

    @Transactional
    Submission update(Long id, SubmissionDto body);

    @Transactional
    boolean delete(Long id);

    @Transactional
    boolean deleteMany(DeleteManySubmissionDto submissionDto);

    @Transactional
    boolean deleteAll();
}
