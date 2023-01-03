package com.project.server.service.impl;

import com.project.server.model.UserModel;
import com.project.server.repository.UserRepository;
import com.project.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserserviceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserModel findbyId(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public UserModel findbyToken(String token) {
        return userRepository.findbyToken(token);
    }

    @Override
    public void save(UserModel user) {
         userRepository.save(user);
    }

    @Override
    public void remove(UUID id) {
        userRepository.remove(id);
    }
}
