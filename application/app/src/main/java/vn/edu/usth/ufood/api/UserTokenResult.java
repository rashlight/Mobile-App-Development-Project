package vn.edu.usth.ufood.api;

import com.google.gson.annotations.SerializedName;

public class UserTokenResult {
    @SerializedName("userid")
    private String userid;
    @SerializedName("firstname")
    private String firstname;
    @SerializedName("secondname")
    private String secondname;
    @SerializedName("gender")
    private String gender;
    @SerializedName("role")
    private String role;
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;
    @SerializedName("createddate")
    private String createddate;
    @SerializedName("avatarContent")
    private String avatarContent;
    @SerializedName("dob")
    private String dob;
    @SerializedName("email")
    private String email;
    @SerializedName("token")
    private String token;
    @SerializedName("tokenGeneratedDate")
    private String tokenGeneratedDate;

    public UserTokenResult(String userid, String firstname, String secondname, String gender, String role, String username, String password, String createddate, String avatarContent, String dob, String email, String token, String tokenGeneratedDate) {
        this.userid = userid;
        this.firstname = firstname;
        this.secondname = secondname;
        this.gender = gender;
        this.role = role;
        this.username = username;
        this.password = password;
        this.createddate = createddate;
        this.avatarContent = avatarContent;
        this.dob = dob;
        this.email = email;
        this.token = token;
        this.tokenGeneratedDate = tokenGeneratedDate;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getCreateddate() {
        return createddate;
    }

    public void setCreateddate(String createddate) {
        this.createddate = createddate;
    }

    public String getAvatarContent() {
        return avatarContent;
    }

    public void setAvatarContent(String avatarContent) {
        this.avatarContent = avatarContent;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenGeneratedDate() {
        return tokenGeneratedDate;
    }

    public void setTokenGeneratedDate(String tokenGeneratedDate) {
        this.tokenGeneratedDate = tokenGeneratedDate;
    }
}
