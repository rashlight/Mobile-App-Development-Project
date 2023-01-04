package com.project.server.repository;

import com.project.server.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserLoginRepository  extends JpaRepository<UserLoginDetail,UUID>{

    UserLoginDetail findByToken(String Token);
}
