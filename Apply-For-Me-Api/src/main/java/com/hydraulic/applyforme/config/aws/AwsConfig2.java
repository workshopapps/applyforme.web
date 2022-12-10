package com.hydraulic.applyforme.config.aws;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//@Configuration

//public class AwsConfig2 {
//
//    @Value("${aws.access-key}")
//>>>>>>> 8504ce81b3ccab83c93a93bdda7fc706c6f2634e:Apply-For-Me-Api/src/main/java/com/hydraulic/applyforme/config/aws/AwsConfig2.java
//    private String accessKeyId;
//
//    @Value("${access.key.secret}")
//    private String accessKeySecret;
//
//    @Value("${s3.region.name}")
//    private String s3RegionName;
//
//    @Bean
//<<<<<<< HEAD:Apply-For-Me-Api/src/main/java/com/hydraulic/applyforme/config/aws/AwsConfig.java
//    public AmazonS3 getAmazonS3Client() {
//        final BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(accessKeyId, accessKeySecret);
//        // Get Amazon S3 client and return the S3 client object
//=======
//    @Primary
//    public AmazonS3 getS3Client() {
//        final BasicAWSCredentials basicAwsCredentials = new BasicAWSCredentials(accessKeyId, accessKeySecret);
//>>>>>>> 8504ce81b3ccab83c93a93bdda7fc706c6f2634e:Apply-For-Me-Api/src/main/java/com/hydraulic/applyforme/config/aws/AwsConfig2.java
//        return AmazonS3ClientBuilder
//                .standard()
//                .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
//                .withRegion(s3RegionName)
//                .build();
//    }
//
//}