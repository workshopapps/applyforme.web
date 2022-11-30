package com.hydraulic.applyforme.service.impl.aws;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Component
public class S3Service {
    private final AmazonS3 awsS3;
    private static final short GENERATED_PRE_SIGNED_URL_EXPIRY_PERIOD = 10;

    @Autowired
    public S3Service(AmazonS3 amazonS3) {
        this.awsS3 = amazonS3;
    }

    public String generatePreSignedUrl(String fileExt, String bucketName) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR, GENERATED_PRE_SIGNED_URL_EXPIRY_PERIOD); // // Generated URL will be valid for 10 validity of 10 minutes
        return awsS3.generatePresignedUrl(bucketName, generateFilename(fileExt), calendar.getTime(), HttpMethod.PUT).toString();
    }

    public String getPreSignedUrl(String fileExt, String bucketName) {
        Date expiration = new Date();
        long expTimeMillis = expiration.getTime();
        expTimeMillis += 1000 * 60;
        expiration.setTime(expTimeMillis);

        GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucketName, generateFilename(fileExt))
                .withMethod(HttpMethod.PUT)
                .withExpiration(expiration);
        return awsS3.generatePresignedUrl(request).toString();
    }

    public String generateFilename(String extension) {
        return UUID.randomUUID().toString().concat(extension);
    }
}
