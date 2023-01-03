package com.project.server.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID userid;
    @OneToOne(mappedBy = "User",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private UserLoginDetail LoginDetail;
    @OneToOne(mappedBy = "User",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private UserAccountDetail AccountDetail;

    public UUID getUserid() {
        return userid;
    }

    public void setUserid(UUID userid) {
        this.userid = userid;
    }

    public UserLoginDetail getLoginDetail() {
        return LoginDetail;
    }

    public void setLoginDetail(UserLoginDetail loginDetail) {
        LoginDetail = loginDetail;
    }

    public UserAccountDetail getAccountDetail() {
        return AccountDetail;
    }

    public void setAccountDetail(UserAccountDetail accountDetail) {
        AccountDetail = accountDetail;
    }
}