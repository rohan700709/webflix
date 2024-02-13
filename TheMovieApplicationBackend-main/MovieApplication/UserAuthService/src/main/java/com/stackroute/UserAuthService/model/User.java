package com.stackroute.UserAuthService.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class User {

    @Id
    private String userEmail;
    private String password;
    private String role;

    public User() {
    }

    public User(String userEmail, String password, String role) {
        this.userEmail = userEmail;
        this.password = password;
        this.role = role;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userEmail='" + userEmail + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
