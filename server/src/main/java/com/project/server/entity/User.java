package com.project.server.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type="org.hibernate.type.UUIDCharType")
    @Column(name = "user_id",columnDefinition = "VARCHAR(255)", nullable = false)
    private UUID userid;
    @Column(name = "created_date",nullable = false)
    private Date createddate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="logindetail_id",referencedColumnName = "id")
    private UserLoginDetail LoginDetail;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="accountdetail_id",referencedColumnName = "id")
    private UserAccountDetail AccountDetail;

    public User() {
    }

    public User(UUID userid, Date createddate, UserLoginDetail loginDetail, UserAccountDetail accountDetail) {
        this.userid = userid;
        this.createddate = createddate;
        LoginDetail = loginDetail;
        AccountDetail = accountDetail;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

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
