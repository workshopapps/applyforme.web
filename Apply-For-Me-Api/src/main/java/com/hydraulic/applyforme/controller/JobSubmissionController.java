package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.dto.FileDto;
import com.hydraulic.applyforme.model.pojo.SubmissionResponse;
import com.hydraulic.applyforme.service.FileService;
import com.hydraulic.applyforme.service.JobSubmissionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.ExecutionException;

import static com.hydraulic.applyforme.constants.AppConstants.*;

@RestController
@RequestMapping(
        value = "submission",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class JobSubmissionController {

    private final JobSubmissionService service;

    private final FileService fileService;




    public JobSubmissionController(JobSubmissionService service, FileService fileService) {
        this.service = service;
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public FileDto uploadResume(@RequestParam("doc") MultipartFile file) {
        return fileService.saveMemberPictures(file.getContentType());
    }
    @GetMapping("/applier/count/{applierId}")
    public Long totalApplierEntry(@PathVariable(name = "applierId") Long id){
        return service.countAllSubmissions(id);
    }

    @GetMapping("/entries")
    public SubmissionResponse getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = DEFAULT_SORT_DIRECTION, required = false) String sortDir){
        return service.getAllJobSubmission(pageNo, pageSize, sortBy, sortDir);
    }


}
