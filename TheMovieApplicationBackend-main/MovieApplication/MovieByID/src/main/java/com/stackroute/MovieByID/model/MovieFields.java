package com.stackroute.MovieByID.model;

import java.util.List;

public class MovieFields {
    private int id;
    private String title;
    private String overview;
    private String poster_path;
    private String backdrop_path;
    private List<Genre> genres;
    private String release_date;
    private float vote_average;
//    private String original_language;
//    private int runtime;
//    private String status;


    public MovieFields() {
    }

    public MovieFields(int id, String title, String overview, String poster_path, String backdrop_path, List<Genre> genres, String release_date, float vote_average) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.poster_path = poster_path;
        this.backdrop_path = backdrop_path;
        this.genres = genres;
        this.release_date = release_date;
        this.vote_average = vote_average;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    @Override
    public String toString() {
        return "MovieSummary{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", overview='" + overview + '\'' +
                ", poster_path='" + poster_path + '\'' +
                ", backdrop_path='" + backdrop_path + '\'' +
                ", genres=" + genres +
                ", release_date='" + release_date + '\'' +
                ", vote_average=" + vote_average +
                '}';
    }
}
