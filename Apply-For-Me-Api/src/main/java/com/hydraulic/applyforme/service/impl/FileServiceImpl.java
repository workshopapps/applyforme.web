package com.hydraulic.applyforme.service.impl;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.hydraulic.applyforme.model.dto.FileDto;
import com.hydraulic.applyforme.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Slf4j
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private AmazonS3 amazonS3;

    @Value("${s3.bucket.member.pictures}")
    private String memberPicturesBucket;

    @Value("${s3.bucket.cover.letters.of.professional.profiles}")
    private String coverLettersBucket;

    @Value("${s3.bucket.passport.of.professional.profiles}")
    private String passportsBucket;

    @Value("${s3.bucket.resumes}")
    private String resumesBucket;

    @Override
    public FileDto saveMemberPictures(String extension) {
        return FileDto.builder()
                .fileUrl(save(extension, memberPicturesBucket))
                .build();
    }

    @Override
    public FileDto saveCoverLetters(String extension) {
        return FileDto.builder()
                .fileUrl(save(extension, coverLettersBucket))
                .build();
    }

    @Override
    public FileDto savePassports(String extension) {
        return FileDto.builder()
                .fileUrl(save(extension, passportsBucket))
                .build();
    }

    @Override
    public FileDto saveResumes(String extension) {
        return FileDto.builder()
                .fileUrl(save(extension, resumesBucket))
                .build();
    }

    @Async
    public String fetchFile(String fileName, String bucketName) {
        if (!amazonS3.doesObjectExist(bucketName, fileName))
            return ("File does not exist");
        log.info("Generating signed URL for file name {}", fileName);
        return generateUrl(fileName, bucketName, HttpMethod.GET);
    }

    @Async
    public String save(String extension, String bucketName) {
        String fileName = UUID.randomUUID() + extension;
        return generateUrl(fileName, bucketName, HttpMethod.PUT);
    }

    private String generateUrl(String fileName, String bucketName, HttpMethod httpMethod) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, 1); // Generated URL will be valid for 24 hours
        return amazonS3.generatePresignedUrl(bucketName, fileName, calendar.getTime(), httpMethod).toString();
    }
}
