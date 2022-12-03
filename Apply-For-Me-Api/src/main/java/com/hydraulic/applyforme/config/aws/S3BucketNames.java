package com.hydraulic.applyforme.config.aws;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "aws.buckets")
public class S3BucketNames {

    private String professionalProfileResume;
    private String professionalProfilePassport;
    private String professionalProfileCoverLetter;
    private String memberAvatar;

}
