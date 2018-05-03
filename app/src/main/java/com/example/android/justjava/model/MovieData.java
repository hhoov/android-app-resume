package com.example.android.justjava.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class MovieData {
    private int rank;
    private String title;
    private int year;
    private String imdbId;
    private double imdbRating;
    private int imdbVotes;
    public String poster;
    public String imdbLink;

    @JsonGetter("rank")
    public int getRank() {
        return rank;
    }

    @JsonSetter("rank")
    public void setRank(int rank) {
        this.rank = rank;
    }

    @JsonGetter("title")
    public String getTitle() {
        return title;
    }

    @JsonSetter("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonGetter("year")
    public int getYear() {
        return year;
    }

    @JsonSetter("year")
    public void setYear(int year) {
        this.year = year;
    }

    @JsonGetter("imdbId")
    public String getImdbId() {
        return imdbId;
    }

    @JsonSetter("imdbId")
    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    @JsonGetter("imdbRating")
    public double getImdbRating() {
        return imdbRating;
    }

    @JsonSetter("imdbRating")
    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    @JsonGetter("imdbVotes")
    public int getImdbVotes() {
        return imdbVotes;
    }

    @JsonSetter("imdbVotes")
    public void setImdbVotes(int imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    @JsonGetter("poster")
    public String getPoster() {
        return poster;
    }

    @JsonSetter("poster")
    public void setPoster(String poster) {
        this.poster = poster;
    }

    @JsonGetter("imdbLink")
    public String getImdbLink() {
        return imdbLink;
    }

    @JsonSetter("imdbLink")
    public void setImdbLink(String imdbLink) {
        this.imdbLink = imdbLink;
    }

}
