package com.project.server.dto;

import java.sql.Time;
import java.sql.Date;
import java.util.UUID;

public class UserModel {
    private UUID userid;
    private String firstname;
    private String secondname;
    private String gender;
    private Date Dob;
    private String role;
    private String username;
    private String password;
    private String Email;
    private String Token;
    private Time TokenGeneratedDate;
    private Date createddate;
    private String avatarContent;

    public UserModel(UUID userid,
                     String firstname,
                     String secondname,
                     Date dob, String role,
                     String username,
                     String password,
                     String gender,
                     String email,
                     String token,
                     Time tokenGeneratedDate,
                     Date createddate,
                     String avatarContent) {
        this.userid = userid;
        this.firstname = firstname;
        this.secondname = secondname;
        Dob = dob;
        this.role = role;
        this.username = username;
        this.password = password;
        this.gender = gender;
        Email = email;
        Token = token;
        TokenGeneratedDate = tokenGeneratedDate;
        this.createddate=createddate;
        this.avatarContent = avatarContent;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public String getAvatarContent() {
        return avatarContent;
    }

    public void setAvatarContent(String avatarContent) {
        this.avatarContent = avatarContent;
    }
}
