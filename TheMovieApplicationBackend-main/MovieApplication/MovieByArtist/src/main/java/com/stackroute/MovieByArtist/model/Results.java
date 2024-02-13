package com.stackroute.MovieByArtist.model;

import java.util.List;

public class Results {
    private int total_results;
    private int total_pages;
    private List<ArtistFields> results;

    public Results() {
    }

    public Results(int total_results, int total_pages, List<ArtistFields> results) {
        this.total_results = total_results;
        this.total_pages = total_pages;
        this.results = results;
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

    public List<ArtistFields> getResults() {
        return results;
    }

    public void setResults(List<ArtistFields> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Results{" +
                "total_results=" + total_results +
                ", total_pages=" + total_pages +
                ", results=" + results +
                '}';
    }
}
