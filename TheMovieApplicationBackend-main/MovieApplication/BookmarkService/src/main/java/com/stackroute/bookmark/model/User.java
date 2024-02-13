package com.stackroute.bookmark.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class User {

    @Id
    private String userEmail;
    private Bookmark bookmark;

    public User() {
    }

    public User(String userEmail, Bookmark bookmark) {
        this.userEmail = userEmail;
        this.bookmark = bookmark;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Bookmark getBookmark() {
        return bookmark;
    }

    public void setBookmark(Bookmark bookmark) {
        this.bookmark = bookmark;
    }

    @Override
    public String toString() {
        return "User{" +
                "userEmail='" + userEmail + '\'' +
                ", bookmark=" + bookmark +
                '}';
    }
}
