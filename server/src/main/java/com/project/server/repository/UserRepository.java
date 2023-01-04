package com.project.server.repository;

import com.project.server.entity.*;

import java.util.UUID;

public interface UserRepository extends Repository<User>{
    User findbyAccDetailId(UUID ID);
    User findbyAccLoginId(UUID ID);
}
