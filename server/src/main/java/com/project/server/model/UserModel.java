package com.project.server.model;

import com.project.server.entity.*;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;

public class UserModel {
    private UUID UserID;

    private String firstname;
    private String secondname;
    private String gender;
    private Date Dob;
    private String role;
    private String username;
    private String password;
    private String email;
    private String Token;
    private Time TokenGeneratedDate;
    public UserModel() {
    }


    public void loadFromEntity(User MainUser, UserAccountDetail Accdetail,UserLoginDetail Logindetail ){
        this.UserID = MainUser.getUserid();
        this.firstname = Accdetail.getFirstname();
        this.secondname = Accdetail.getSecondname();
        this.gender = Accdetail.getGender();
        this.Dob = Accdetail.getDob();
        this.role= Accdetail.getRole();
        this.username = Logindetail.getUsername();
        this.password = Logindetail.getPassword();
        this.email = Logindetail.getEmail();
        this.Token = Logindetail.getToken();
        this.TokenGeneratedDate = Logindetail.getTokenGeneratedDate();
    }

    public UUID getUserID() {
        return UserID;
    }

    public void setUserID(UUID userID) {
        UserID = userID;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", secondname='" + secondname + '\'' +
                ", gender='" + gender + '\'' +
                ", Dob=" + Dob +
                ", role='" + role + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", Token='" + Token + '\'' +
                ", TokenGeneratedDate=" + TokenGeneratedDate +
                '}';
    }
}
