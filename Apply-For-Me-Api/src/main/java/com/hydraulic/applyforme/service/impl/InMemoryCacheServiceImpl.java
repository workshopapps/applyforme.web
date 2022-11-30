package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.repository.InMemoryRepository;
import com.hydraulic.applyforme.service.InMemoryCacheService;
import org.springframework.stereotype.Component;

@Component
public class InMemoryCacheServiceImpl implements InMemoryCacheService {

    private final InMemoryRepository repository;

    public InMemoryCacheServiceImpl(InMemoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public void set(String key, Object value) {
        repository.set(key, value);
    }

    @Override
    public Object get(String key) {
        return repository.get(key);
    }

    @Override
    public boolean exists(String key) {
        return repository.exists(key);
    }

    @Override
    public boolean remove(String key) {
        return repository.remove(key);
    }
}
