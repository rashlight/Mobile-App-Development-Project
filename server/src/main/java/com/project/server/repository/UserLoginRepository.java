package com.project.server.repository;

import com.project.server.entity.*;

import java.util.List;
import java.util.UUID;

public interface UserLoginRepository  extends Repository<UserLoginDetail>{

    UserLoginDetail findByToken(String Token);
}
