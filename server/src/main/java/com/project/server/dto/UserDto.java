package com.project.server.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * A DTO for the {@link com.project.server.entity.User} entity
 */
public class UserDto implements Serializable {
    private final UUID userid;
    private final UserLoginDetailDto LoginDetail;
    private final UserAccountDetailDto AccountDetail;

    public UserDto(UUID userid, UserLoginDetailDto loginDetail, UserAccountDetailDto accountDetail) {
        this.userid = userid;
        LoginDetail = loginDetail;
        AccountDetail = accountDetail;
    }

    public UUID getUserid() {
        return userid;
    }

    public UserLoginDetailDto getLoginDetail() {
        return LoginDetail;
    }

    public UserAccountDetailDto getAccountDetail() {
        return AccountDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto entity = (UserDto) o;
        return Objects.equals(this.userid, entity.userid) &&
                Objects.equals(this.LoginDetail, entity.LoginDetail) &&
                Objects.equals(this.AccountDetail, entity.AccountDetail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, LoginDetail, AccountDetail);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "userid = " + userid + ", " +
                "LoginDetail = " + LoginDetail + ", " +
                "AccountDetail = " + AccountDetail + ")";
    }
}