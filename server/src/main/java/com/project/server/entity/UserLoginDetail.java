package com.project.server.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.sql.Time;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "UserLoginDetail")
public class UserLoginDetail {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;
    @OneToOne
    @MapsId
    @JoinColumn(name="userid")
    private User userid;
    private String username;
    private String password;
    private String email;
    private String Token;
    private Time TokenGeneratedDate;

    public UserLoginDetail() {
    }

    public UserLoginDetail(UUID id,
                           User userid,
                           String username,
                           String password,
                           String email,
                           String token,
                           Time tokenGeneratedDate) {
        this.id = id;
        this.userid = userid;
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

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
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
