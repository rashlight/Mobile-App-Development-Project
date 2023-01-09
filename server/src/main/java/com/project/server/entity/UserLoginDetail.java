package com.project.server.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;

import java.sql.Time;

import java.util.UUID;

@Entity
@Table(name = "UserLoginDetail")
public class UserLoginDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type="org.hibernate.type.UUIDCharType")
    @Column(name = "id",columnDefinition = "VARCHAR(255)", nullable = false,unique = true)
    private UUID id;
    @Column(name="username",nullable = false,unique = true)
    private String username;
    @Column(name="password",nullable = false)
    private String password;
    @Column(name="email",nullable = false)
    private String email;
    @Column(name="Token",nullable = false,unique = true)
    private String Token;
    @Column(name="TokenGeneratedDate",nullable = false)
    private Time TokenGeneratedDate;

    public UserLoginDetail() {
    }

    public UserLoginDetail(UUID id,
                           String username,
                           String password,
                           String email,
                           String token,
                           Time tokenGeneratedDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        Token = token;
        TokenGeneratedDate = tokenGeneratedDate;
    }

    public UserLoginDetail(String username,
                           String password,
                           String email,
                           String token,
                           Time tokenGeneratedDate) {
        this.username = username;
        this.password = password;
        this.email = email;
        Token = token;
        TokenGeneratedDate = tokenGeneratedDate;
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
