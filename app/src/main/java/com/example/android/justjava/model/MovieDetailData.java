package com.example.android.justjava.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieDetailData {
    private final double imdbRating;
    private final int imdbVotes;
    private final String imdbId;
    private final String title;
    private final int year;
    private final String rated;
    private final String released;
    private final String runtime;

    private final String[] genre;

    private final String director;
    private final String writer;

    private final String[] actors;
    private final String plot;

    private final String[] language;

    private final String country;
    private final String awards;
    private final String poster;
    private final String metascore;

    @JsonCreator
    public MovieDetailData(
            @JsonProperty("imdbRating") double imdbRating,
            @JsonProperty("imdbVotes") int imdbVotes,
            @JsonProperty("imdbId") String imdbId,
            @JsonProperty("title") String title,
            @JsonProperty("year") int year,
            @JsonProperty("rated") String rated,
            @JsonProperty("released") String released,
            @JsonProperty("runtime") String runtime,
            @JsonProperty("genre") String[] genre,
            @JsonProperty("director") String director,
            @JsonProperty("writer") String writer,
            @JsonProperty("actors") String[] actors,
            @JsonProperty("plot") String plot,
            @JsonProperty("language") String[] language,
            @JsonProperty("country") String country,
            @JsonProperty("awards") String awards,
            @JsonProperty("poster") String poster,
            @JsonProperty("metascore") String metascore) {
        this.imdbRating = imdbRating;
        this.imdbVotes = imdbVotes;
        this.imdbId = imdbId;
        this.title = title;
        this.year = year;
        this.rated = rated;
        this.released = released;
        this.runtime = runtime;
        this.genre = genre;
        this.director = director;
        this.writer = writer;
        this.actors = actors;
        this.plot = plot;
        this.language = language;
        this.country = country;
        this.awards = awards;
        this.poster = poster;
        this.metascore = metascore;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public int getImdbVotes() {
        return imdbVotes;
    }

    public String getImdbId() {
        return imdbId;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getRated() {
        return rated;
    }

    public String getReleased() {
        return released;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getGenre(int index) {
        return genre[index];
    }

    public String getDirector() {
        return director;
    }

    public String getWriter() {
        return writer;
    }

    public String getActors(int index) {
        return actors[index];
    }

    public String getPlot() {
        return plot;
    }

    public String getLanguage(int index) {
        return language[index];
    }

    public String getCountry() {
        return country;
    }

    public String getAwards() {
        return awards;
    }

    public String getPoster() {
        return poster;
    }

    public String getMetascore() {
        return metascore;
    }


}
