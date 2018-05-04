package com.example.android.justjava.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieData {
    private int rank;
    private String title;
    private int year;
    private String imdbId;
    private double imdbRating;
    private int imdbVotes;
    public String poster;
    public String imdbLink;

    @JsonProperty("rank")
    public int getRank() {
        return rank;
    }

    @JsonProperty("rank")
    public void setRank(int rank) {
        this.rank = rank;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("year")
    public int getYear() {
        return year;
    }

    @JsonProperty("year")
    public void setYear(int year) {
        this.year = year;
    }

    @JsonProperty("imdbId")
    public String getImdbId() {
        return imdbId;
    }

    @JsonProperty("imdbId")
    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    @JsonProperty("imdbRating")
    public double getImdbRating() {
        return imdbRating;
    }

    @JsonProperty("imdbRating")
    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    @JsonProperty("imdbVotes")
    public int getImdbVotes() {
        return imdbVotes;
    }

    @JsonProperty("imdbVotes")
    public void setImdbVotes(int imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    @JsonProperty("poster")
    public String getPoster() {
        return poster;
    }

    @JsonProperty("poster")
    public void setPoster(String poster) {
        this.poster = poster;
    }

    @JsonProperty("imdbLink")
    public String getImdbLink() {
        return imdbLink;
    }

    @JsonProperty("imdbLink")
    public void setImdbLink(String imdbLink) {
        this.imdbLink = imdbLink;
    }

}
