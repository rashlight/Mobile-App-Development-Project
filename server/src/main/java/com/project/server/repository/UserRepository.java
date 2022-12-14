package com.project.server.repository;

import com.project.server.entity.*;
import com.project.server.repository.custom_repository.UserCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<User,UUID>, UserCustomRepository {

}
