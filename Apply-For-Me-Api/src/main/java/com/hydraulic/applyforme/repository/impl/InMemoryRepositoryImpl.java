package com.hydraulic.applyforme.repository.impl;

import com.hydraulic.applyforme.repository.InMemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class InMemoryRepositoryImpl implements InMemoryRepository {

    @Autowired
    private ValueOperations store;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void set(String key, Object value) {
        store.set(key, value);
    }

    @Override
    public Object get(String key) {
        return store.get(key);
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
