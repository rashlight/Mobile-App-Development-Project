package com.project.server.repository.impl;

import com.project.server.model.UserModel;
import com.project.server.repository.UserRepository;

import java.util.List;
import java.util.UUID;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public List<UserModel> findAll() {
        return null;
    }

    @Override
    public UserModel findById(UUID id) {
        return null;
    }

    @Override
    public void save(UserModel model) {

    }

    @Override
    public void remove(UUID id) {

    }
}
