package com.hydraulic.applyforme.repository.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hydraulic.applyforme.repository.InMemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class InMemoryRepositoryImpl implements InMemoryRepository {

    @Autowired
    private ValueOperations store;

    @Autowired
    public ObjectMapper objectMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void set(String key, Object value) {
        try {
            String json = objectMapper.writeValueAsString(value);
            store.set(key, json);
        }
        catch (JsonProcessingException ex) {
        }
    }

    @Override
    public void set(String key, Object value, long seconds) {
        try {
            store.set(key, objectMapper.writeValueAsString(value), seconds, TimeUnit.SECONDS);
        }
        catch (JsonProcessingException ex) {
        }
    }

    @Override
    public Object get(String key, Class<?> clazz) {
        try {
            String value = (String) store.get(key);
            return objectMapper.readValue(value, clazz);
        }
        catch (JsonProcessingException ex) {
            return null;
        }
    }

    @Override
    public Object get(String key) {
        try {
            String value = (String) store.get(key);
            return objectMapper.readValue(value, Object.class);
        }
        catch (JsonProcessingException ex) {
            return null;
        }
    }

    @Override
    public boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public boolean remove(String key) {
        return redisTemplate.delete(key);
    }
}
