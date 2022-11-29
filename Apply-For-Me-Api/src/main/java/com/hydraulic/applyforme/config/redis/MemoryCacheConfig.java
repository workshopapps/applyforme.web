package com.hydraulic.applyforme.config.redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@Configuration
public class MemoryCacheConfig {

    @Autowired
    private RedisCredentials credentials;

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(credentials.getHost());
        configuration.setPort(credentials.getPort());
        configuration.setPassword(RedisPassword.of(credentials.getPassword()));
        configuration.setUsername(credentials.getUsername());
        return new JedisConnectionFactory(configuration);
    }

    @Bean
    @Primary
    public RedisTemplate redisTemplate(JedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        return template;
    }

    @Bean
    public ValueOperations<String, Object> valueOperations(RedisTemplate redisTemplate) {
        return redisTemplate.opsForValue();
    }
}
