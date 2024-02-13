package com.stackroute.TrendingMovies.model;

import java.util.List;

public class MovieList {
    private int page;
    private int total_results;
    private int total_pages;
    private List<MovieFields> movieList;

    public MovieList() {
    }

    public MovieList(int page, int total_results, int total_pages, List<MovieFields> movieList) {
        this.page = page;
        this.total_results = total_results;
        this.total_pages = total_pages;
        this.movieList = movieList;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<MovieFields> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<MovieFields> movieList) {
        this.movieList = movieList;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    @Override
    public String toString() {
        return "MovieList{" +
                "page=" + page +
                ", total_results=" + total_results +
                ", total_pages=" + total_pages +
                ", movieList=" + movieList +
                '}';
    }
}
