package com.stackroute.bookmark.model;

import java.util.List;

public class Bookmark {

    private int bookmarkId;
    private String bookmarkName;
    private List<Movie> movie;

    public Bookmark() {
    }

    public Bookmark(int bookmarkId, String bookmarkName, List<Movie> movie) {
        this.bookmarkId = bookmarkId;
        this.bookmarkName = bookmarkName;
        this.movie = movie;
    }

    public int getBookmarkId() {
        return bookmarkId;
    }

    public void setBookmarkId(int bookmarkId) {
        this.bookmarkId = bookmarkId;
    }

    public String getBookmarkName() {
        return bookmarkName;
    }

    public void setBookmarkName(String bookmarkName) {
        this.bookmarkName = bookmarkName;
    }

    public List<Movie> getMovie() {
        return movie;
    }

    public void setMovie(List<Movie> movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Bookmark{" +
                "bookmarkId=" + bookmarkId +
                ", bookmarkName='" + bookmarkName + '\'' +
                ", movie=" + movie +
                '}';
    }
}
