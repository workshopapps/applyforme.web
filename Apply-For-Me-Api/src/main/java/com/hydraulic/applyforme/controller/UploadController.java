package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.config.aws.S3BucketNames;
import com.hydraulic.applyforme.service.impl.aws.S3Service;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "upload",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class UploadController {
    private final S3Service service;
    private final S3BucketNames bucketNames;

    public UploadController(S3Service service, S3BucketNames bucketNames) {
        this.service = service;
        this.bucketNames = bucketNames;
    }

    @PostMapping("/pre-signed-resume")
    public String genResume(@RequestParam(name = "extension") String fileExt ) {
        return service.generatePreSignedUrl(fileExt, bucketNames.getProfessionalProfileResume());
    }

    @PostMapping("/pre-signed-passport")
    public String genPassport(@RequestParam(name = "extension") String fileExt ) {
        return service.generatePreSignedUrl(fileExt, bucketNames.getProfessionalProfilePassport());
    }

    @PostMapping("/pre-signed-cover-letter")
    public String genCoverLetter(@RequestParam(name = "extension") String fileExt ) {
        return service.generatePreSignedUrl(fileExt, bucketNames.getProfessionalProfileCoverLetter());
    }

    @PostMapping("/pre-signed-avatar")
    public String genAvatar(@RequestParam(name = "extension") String fileExt ) {
        return service.generatePreSignedUrl(fileExt, bucketNames.getMemberAvatar());
    }

}
