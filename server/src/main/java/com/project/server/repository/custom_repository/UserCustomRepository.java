package com.project.server.repository.custom_repository;

import com.project.server.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface UserCustomRepository {
    @Query("Select u from User u where u.logindetail_id= :id ")
    User findIdfromLoginid(@Param("id") UUID id);
    @Query("Select u from User u where u.AccountDetail_id= :id ")
    User findIdfromAccountid(@Param("id") UUID id);
}
