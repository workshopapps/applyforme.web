package com.hydraulic.applyforme.repository;

public interface InMemoryRepository {
    public void set(String key, Object value);

    Object get(String key);

    boolean exists(String key);

    boolean remove(String key);
}
