package com.project.server.service.impl;

import com.project.server.entity.*;

import com.project.server.repository.*;

import com.project.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.UUID;
class UserModel{
    private UUID userid;
    private String firstname;
    private String secondname;
    private Date Dob;
    private String role;
    private String username;
    private String password;
    private String Email;
    private String Token;
    private Time TokenGeneratedDate;

    public UserModel(UUID userid,
                     String firstname,
                     String secondname,
                     Date dob, String role,
                     String username,
                     String password,
                     String email,
                     String token,
                     Time tokenGeneratedDate) {
        this.userid = userid;
        this.firstname = firstname;
        this.secondname = secondname;
        Dob = dob;
        this.role = role;
        this.username = username;
        this.password = password;
        Email = email;
        Token = token;
        TokenGeneratedDate = tokenGeneratedDate;
    }

    public UUID getUserid() {
        return userid;
    }

    public void setUserid(UUID userid) {
        this.userid = userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public Date getDob() {
        return Dob;
    }

    public void setDob(Date dob) {
        Dob = dob;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public Time getTokenGeneratedDate() {
        return TokenGeneratedDate;
    }

    public void setTokenGeneratedDate(Time tokenGeneratedDate) {
        TokenGeneratedDate = tokenGeneratedDate;
    }
}
@Service
public class UserserviceImpl implements UserService<UserModel> {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserLoginRepository userLoginRepository;
    @Autowired
    private UserAccountRepository userAccountRepository;
    @Autowired
    public UserserviceImpl(UserRepository userRepository,
                           UserLoginRepository userLoginRepository,
                           UserAccountRepository userAccountRepository){
        this.userRepository = userRepository;
        this.userLoginRepository=userLoginRepository;
        this.userAccountRepository=userAccountRepository;
    }

    @Override
    public List<UserModel> findAll() {
        return null;
    }

    @Override
    public UserModel findbyId(UUID id) {
        User user = userRepository.findById(id);
        return null;
    }

    @Override
    public UserModel findbyToken(String token) {
        return null;
    }

    @Override
    public void save(UserModel model) {

    }

    @Override
    public void remove(UUID id) {

    }
}
