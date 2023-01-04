package com.project.server.dto;

import java.io.Serializable;
import java.sql.Time;
import java.util.Objects;
import java.util.UUID;

/**
 * A DTO for the {@link com.project.server.entity.UserLoginDetail} entity
 */
public class UserLoginDetailDto implements Serializable {
    private final UUID id;
    private final String username;
    private final String password;
    private final String email;
    private final String Token;
    private final Time TokenGeneratedDate;

    public UserLoginDetailDto(UUID id, String username, String password, String email, String token, Time tokenGeneratedDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        Token = token;
        TokenGeneratedDate = tokenGeneratedDate;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return Token;
    }

    public Time getTokenGeneratedDate() {
        return TokenGeneratedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLoginDetailDto entity = (UserLoginDetailDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.username, entity.username) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.Token, entity.Token) &&
                Objects.equals(this.TokenGeneratedDate, entity.TokenGeneratedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email, Token, TokenGeneratedDate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "username = " + username + ", " +
                "password = " + password + ", " +
                "email = " + email + ", " +
                "Token = " + Token + ", " +
                "TokenGeneratedDate = " + TokenGeneratedDate + ")";
    }
}