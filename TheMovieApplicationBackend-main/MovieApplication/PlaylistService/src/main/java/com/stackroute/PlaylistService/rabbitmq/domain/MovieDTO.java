package com.stackroute.PlaylistService.rabbitmq.domain;


public class MovieDTO {

    private int movieId;
    private String movieTitle;
    private String artistName;
    private String genreName;
    private float rating;

    public MovieDTO() {
    }

    public MovieDTO(int movieId, String movieTitle, String artistName, String genreName, float rating) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.artistName = artistName;
        this.genreName = genreName;
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

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieTitle='" + movieTitle + '\'' +
                ", artistName='" + artistName + '\'' +
                ", genreName='" + genreName + '\'' +
                ", rating=" + rating +
                '}';
    }
}
