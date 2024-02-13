package com.stackroute.PlaylistService.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


public class Playlist {

    private int playlistId;
    private String playlistName;
    private List<Movie> movieList;

    public Playlist() {
    }

    public Playlist(int playlistId, String playlistName, List<Movie> movieList) {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
        this.movieList = movieList;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "playlistId=" + playlistId +
                ", playlistName='" + playlistName + '\'' +
                ", movieList=" + movieList +
                '}';
    }
}
