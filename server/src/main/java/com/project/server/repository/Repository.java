package com.project.server.repository;

import java.util.List;
import java.util.UUID;

public interface Repository<T> {
    List<T> findAll();
    T findById(UUID id);
    void save(T model);
    void remove(UUID id);
}
