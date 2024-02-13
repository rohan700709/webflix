package com.stackroute.MovieByArtist.model;

import java.util.List;

public class MovieFields {
        private int id;
        private String title;
        private String overview;
        private String release_date;
        private List<Integer> genre_ids;
        private String poster_path;

        public MovieFields() {
        }

        public MovieFields(int id, String title, String overview, String release_date, List<Integer> genre_ids, String poster_path) {
            this.id = id;
            this.title = title;
            this.overview = overview;
            this.release_date = release_date;
            this.genre_ids = genre_ids;
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

        public String getRelease_date() {
            return release_date;
        }

        public void setRelease_date(String release_date) {
            this.release_date = release_date;
        }

        public List<Integer> getGenre_ids() {
            return genre_ids;
        }

        public void setGenre_ids(List<Integer> genre_ids) {
            this.genre_ids = genre_ids;
        }

        public String getPoster_path() {
            return poster_path;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
        }

        @Override
        public String toString() {
            return "MovieLists{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", overview='" + overview + '\'' +
                    ", release_date='" + release_date + '\'' +
                    ", genre_ids=" + genre_ids +
                    ", poster_path='" + poster_path + '\'' +
                    '}';
        }
}
