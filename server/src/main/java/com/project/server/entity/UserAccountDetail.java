package com.project.server.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "UserAccountDetail")
public class UserAccountDetail {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", nullable = false,unique = true)
    private UUID id;
    @Column(name="First_name",nullable = false)
    private String firstname;
    @Column(name="Second_name",nullable = false)
    private String secondname;
    @Column(name="Gender",nullable = false)
    private String gender;
    @Column(name="Dob",nullable = false)
    private Date Dob;
    @Column(name="Role")
    private String role;
    public UserAccountDetail(){}

    public UserAccountDetail(UUID id,
                             String firstname,
                             String secondname,
                             String gender,
                             Date dob,
                             String role) {
        this.id = id;
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
