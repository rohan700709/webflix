package com.stackroute.TrendingMovies.model;

import java.util.List;

public class Results {
   private int page;
   private int total_results;
   private int total_pages;
   private List<MovieFields> results;

    public Results() {
    }

    public Results(int page, int total_results, int total_pages, List<MovieFields> results) {
        this.page = page;
        this.total_results = total_results;
        this.total_pages = total_pages;
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<MovieFields> getResults() {
        return results;
    }

    public void setResults(List<MovieFields> results) {
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

    @Override
    public String toString() {
        return "Results{" +
                "page=" + page +
                ", total_results=" + total_results +
                ", total_pages=" + total_pages +
                ", results=" + results +
                '}';
    }
}
