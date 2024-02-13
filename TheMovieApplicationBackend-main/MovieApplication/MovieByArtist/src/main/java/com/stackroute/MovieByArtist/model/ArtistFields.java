package com.stackroute.MovieByArtist.model;

import java.util.List;

public class ArtistFields {
    private String profile_path;
    private int id;
    private List<MovieFields> known_for;

    public ArtistFields() {
    }

    public ArtistFields(String profile_path, int id, List<MovieFields> known_for) {
        this.profile_path = profile_path;
        this.id = id;
        this.known_for = known_for;
    }

    public String getProfile_path() {
        return profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<MovieFields> getKnown_for() {
        return known_for;
    }

    public void setKnown_for(List<MovieFields> known_for) {
        this.known_for = known_for;
    }

    @Override
    public String toString() {
        return "ArtistFields{" +
                "profile_path='" + profile_path + '\'' +
                ", id=" + id +
                ", known_for=" + known_for +
                '}';
    }
}
