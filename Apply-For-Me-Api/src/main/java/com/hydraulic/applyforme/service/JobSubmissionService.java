package com.hydraulic.applyforme.service;

<<<<<<< HEAD
import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.dto.submission.SubmissionDto;
import com.hydraulic.applyforme.model.pojo.SubmissionResponse;
=======
import com.hydraulic.applyforme.model.response.SubmissionResponse;
>>>>>>> 832aac9cc504b87bcff33b458e6a5201fb05ff21

public interface JobSubmissionService {
    Long countAllApplierSubmissions(Long Id);
    SubmissionResponse getAllJobSubmission(int pageNo, int pageSize, String sortBy, String sortDir);
    SubmissionResponse filterJobSubmission(int pageNo, int pageSize, String sortBy, String sortDir, String q);

    SubmissionDto getSubmissionDetails(Long  professionalId, Long submissionId);
}
