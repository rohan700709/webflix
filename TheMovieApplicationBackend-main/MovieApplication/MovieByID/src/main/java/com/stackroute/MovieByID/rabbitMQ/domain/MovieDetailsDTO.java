package com.stackroute.MovieByID.rabbitMQ.domain;

import com.stackroute.MovieByID.model.Genre;

import java.util.List;

public class MovieDetailsDTO {
    private int id;
    private String title;
    private String overview;
    private String posterUrl;
    private String backdropUrl;
    private List<Genre> genres;
    private String release_date;
    private float ratings;

    public MovieDetailsDTO() {
    }

    public MovieDetailsDTO(int id, String title, String overview, String posterUrl, String backdropUrl, List<Genre> genres, String release_date, float ratings) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.posterUrl = posterUrl;
        this.backdropUrl = backdropUrl;
        this.genres = genres;
        this.release_date = release_date;
        this.ratings = ratings;
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

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getBackdropUrl() {
        return backdropUrl;
    }

    public void setBackdropUrl(String backdropUrl) {
        this.backdropUrl = backdropUrl;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public float getRatings() {
        return ratings;
    }

    public void setRatings(float ratings) {
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return "MovieDetailsDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", overview='" + overview + '\'' +
                ", posterUrl='" + posterUrl + '\'' +
                ", backdropUrl='" + backdropUrl + '\'' +
                ", genres=" + genres +
                ", release_date='" + release_date + '\'' +
                ", ratings=" + ratings +
                '}';
    }
}
