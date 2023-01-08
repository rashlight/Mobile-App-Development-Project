package com.project.server.service;


import java.util.List;
import java.util.UUID;

public interface UserService<T> {
    List<T> findAll();
    T findbyId(UUID id);

    T findbyToken(String token);
    void save(T model);
    void remove(UUID id);
    String addNewUser(T user);

    T findbyPassword(String username,String password);
}
