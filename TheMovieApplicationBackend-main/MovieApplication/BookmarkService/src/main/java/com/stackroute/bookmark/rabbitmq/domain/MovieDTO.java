package com.stackroute.bookmark.rabbitmq.domain;

public class MovieDTO {

    private int movieId;
    private String movieTitle;
    private  String artist;
    private String genre;
    private  float rating;

    public MovieDTO() {
    }

    public MovieDTO(int movieId, String movieTitle, String artist, String genre, float rating) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.artist = artist;
        this.genre = genre;
        this.rating = rating;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "movieId=" + movieId +
                ", movieTitle='" + movieTitle + '\'' +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                '}';
    }
}
