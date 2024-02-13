package com.stackroute.PlaylistService.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class User {

    @Id
    private String userEmail;
    private List<Playlist> playlist;

    public User() {
    }

    public User(String userEmail, List<Playlist> playlist) {
        this.userEmail = userEmail;
        this.playlist = playlist;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public List<Playlist> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<Playlist> playlist) {
        this.playlist = playlist;
    }

    @Override
    public String toString() {
        return "User{" +
                "userEmail='" + userEmail + '\'' +
                ", playlist=" + playlist +
                '}';
    }
}
