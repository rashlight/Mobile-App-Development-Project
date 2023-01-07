package com.project.server.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * A DTO for the {@link com.project.server.entity.UserAccountDetail} entity
 */
public class UserAccountDetailDto implements Serializable {
    private final UUID id;
    private final String firstname;
    private final String secondname;
    private final String gender;
    private final Date Dob;
    private final String role;

    public UserAccountDetailDto(UUID id, String firstname, String secondname, String gender, Date dob, String role) {
        this.id = id;
        this.firstname = firstname;
        this.secondname = secondname;
        this.gender = gender;
        Dob = dob;
        this.role = role;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public String getGender() {
        return gender;
    }

    public Date getDob() {
        return Dob;
    }

    public String getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccountDetailDto entity = (UserAccountDetailDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.firstname, entity.firstname) &&
                Objects.equals(this.secondname, entity.secondname) &&
                Objects.equals(this.gender, entity.gender) &&
                Objects.equals(this.Dob, entity.Dob) &&
                Objects.equals(this.role, entity.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, secondname, gender, Dob, role);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "firstname = " + firstname + ", " +
                "secondname = " + secondname + ", " +
                "gender = " + gender + ", " +
                "Dob = " + Dob + ", " +
                "role = " + role + ")";
    }
}