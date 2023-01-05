package com.project.server.repository;

import com.project.server.entity.*;
import com.project.server.repository.custom_repository.UserLoginCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface UserLoginRepository  extends JpaRepository<UserLoginDetail,UUID>, UserLoginCustomRepository {


}
