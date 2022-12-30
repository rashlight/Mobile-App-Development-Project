package com.project.server.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Date;
import java.util.UUID;

@Entity
public class UserAccountDetail {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;
    private UUID userid;
    private String firstname;
    private String secondname;
    private String gender;
    private Date Dob;
    private String role;
    public UserAccountDetail(){}

    public UserAccountDetail(UUID id,
                             UUID userid,
                             String firstname,
                             String secondname,
                             String gender,
                             Date dob,
                             String role) {
        this.id = id;
        this.userid = userid;
        this.firstname = firstname;
        this.secondname = secondname;
        this.gender = gender;
        Dob = dob;
        this.role = role;
    }

    public UserAccountDetail(String firstname, String secondname, String gender, Date dob, String role) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.gender = gender;
        Dob = dob;
        this.role = role;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
}
