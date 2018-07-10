package com.example.android.justjava.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieSummaryData {
    private final int rank;
    private final String title;
    private final int year;
    private final String imdbId;
    private final double imdbRating;
    private final int imdbVotes;
    private final String poster;
    private final String imdbLink;

    @JsonCreator
    public MovieSummaryData(
            @JsonProperty("rank") int rank,
            @JsonProperty("title") String title,
            @JsonProperty("year") int year,
            @JsonProperty("imdbId") String imdbId,
            @JsonProperty("imdbRating") double imdbRating,
            @JsonProperty("imdbVotes") int imdbVotes,
            @JsonProperty("poster") String poster,
            @JsonProperty("imdbLink") String imdbLink) {
        this.rank = rank;
        this.title = title;
        this.year = year;
        this.imdbId = imdbId;
        this.imdbRating = imdbRating;
        this.imdbVotes = imdbVotes;
        this.poster = poster;
        this.imdbLink = imdbLink;
    }

    public int getRank() {
        return rank;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getImdbId() {
        return imdbId;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public int getImdbVotes() {
        return imdbVotes;
    }

    public String getPoster() {
        return poster;
    }

    public String getImdbLink() {
        return imdbLink;
    }

}
