package com.hydraulic.applyforme.config.redis;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "applyforme.redis")
public class RedisCredentials {

    private String host;
    private Integer port;
    private String username;
    private String password;
}
