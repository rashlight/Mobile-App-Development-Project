package com.project.server.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.sql.Date;
import java.util.Base64;
import java.util.UUID;

@Entity
@Table(name = "UserAccountDetail")
public class UserAccountDetail {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", nullable = false,unique = true)
    private UUID id;
    @Column(name="first_name",nullable = false)
    private String firstname;
    @Column(name="second_name",nullable = false)
    private String secondname;
    @Column(name="gender",nullable = false)
    private String gender;
    @Column(name="dob",nullable = false)
    private Date Dob;
    @Column(name="role")
    private String role;
    @Column(name="avatar")
    private String avatarContent;
    public UserAccountDetail(){}

    public UserAccountDetail(UUID id,
                             String firstname,
                             String secondname,
                             String gender,
                             Date dob,
                             String role,
                             String avatarContent) {
        this.id = id;
        this.firstname = firstname;
        this.secondname = secondname;
        this.gender = gender;
        Dob = dob;
        this.role = role;
        this.avatarContent = avatarContent;
    }

    public UserAccountDetail(String firstname, String secondname, String gender, Date dob, String role,String avatarContent) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.gender = gender;
        Dob = dob;
        this.role = role;
        this.avatarContent=avatarContent;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public String getAvatarContent() {
        return avatarContent;
    }

    public void setAvatarContent(String avatarContent) {
        this.avatarContent = avatarContent;
    }
}
