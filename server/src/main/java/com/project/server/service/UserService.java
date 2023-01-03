package com.project.server.service;

import com.project.server.entity.User;
import com.project.server.model.UserModel;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserModel> findAll();
    UserModel findbyId(UUID id);
    UserModel findbyToken(String token);
    void save(UserModel user);
    void remove(UUID id);
}
