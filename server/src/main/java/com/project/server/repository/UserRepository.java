package com.project.server.repository;

import com.project.server.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User,UUID>{
    User findbyAccDetailId(UUID ID);
    User findbyAccLoginId(UUID ID);
}
