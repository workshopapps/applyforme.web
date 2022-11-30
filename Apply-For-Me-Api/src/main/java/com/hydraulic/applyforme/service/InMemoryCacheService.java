package com.hydraulic.applyforme.service;

public interface InMemoryCacheService {

    public void set(String key, Object value);

    void set(String key, Object value, long seconds);

    Object get(String key);

    boolean exists(String key);

    boolean remove(String key);
}
