package com.hydraulic.applyforme.repository;

public interface InMemoryRepository {
    void set(String key, Object value, long seconds);
    public void set(String key, Object value);
    Object get(String key);
    Object get(String key, Class<?> clazz);
    boolean exists(String key);
    boolean remove(String key);
}
