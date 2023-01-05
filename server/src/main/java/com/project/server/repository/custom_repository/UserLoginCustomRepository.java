package com.project.server.repository.custom_repository;

import com.project.server.entity.UserLoginDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserLoginCustomRepository {
    @Query("Select u from UserLoginDetail u where u.Token= :Token ")
    UserLoginDetail findUserByToken(@Param("Token") String token);
    @Query("Select u from UserLoginDetail u where u.username= :username and u.password= :password")
    UserLoginDetail findUserByPassword(@Param("username") String username,@Param("password") String password);
}
