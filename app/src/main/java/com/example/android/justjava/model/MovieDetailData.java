package com.example.android.justjava.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "imdbRating",
        "imdbVotes",
        "imdbId",
        "title",
        "year",
        "rated",
        "released",
        "runtime",
        "genre",
        "director",
        "writer",
        "actors",
        "plot",
        "language",
        "country",
        "awards",
        "poster",
        "metascore"
})

public class MovieDetailData {

    private final double imdbRating;
    private final Integer imdbVotes, year;
    private final String imdbId, title, rated, released, runtime, director, writer, plot, country, awards, poster, metascore;
    private List<String> genre;
    private List<String> actors;
    private List<String> language;

    @JsonCreator
    public MovieDetailData(
            @JsonProperty("imdbRating") double imdbRating, @JsonProperty("imdbVotes") int imdbVotes, @JsonProperty("imdbId") String imdbId,
            @JsonProperty("title") String title, @JsonProperty("year") int year, @JsonProperty("rated") String rated, @JsonProperty("released") String released,
            @JsonProperty("runtime") String runtime, @JsonProperty("genre") List<String> genre, @JsonProperty("director") String director, @JsonProperty("writer") String writer,
            @JsonProperty("actors") List<String> actors, @JsonProperty("plot") String plot, @JsonProperty("language") List<String> language, @JsonProperty("country") String country,
            @JsonProperty("awards") String awards, @JsonProperty("poster") String poster, @JsonProperty("metascore") String metascore) {
        super();
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

    @JsonProperty("imdbRating")
    public double getImdbRating() {
        return imdbRating;
    }

    @JsonProperty("imdbVotes")
    public int getImdbVotes() {
        return imdbVotes;
    }

    @JsonProperty("imdbId")
    public String getImdbId() {
        return imdbId;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("year")
    public int getYear() {
        return year;
    }

    @JsonProperty("rated")
    public String getRated() {
        return rated;
    }

    @JsonProperty("released")
    public String getReleased() {
        return released;
    }

    @JsonProperty("runtime")
    public String getRuntime() {
        return runtime;
    }

    @JsonProperty("genre")
    public List<String> getGenre() {
        if (!(genre == null)) return genre;
        else return new ArrayList<>();
    }

    @JsonProperty("director")
    public String getDirector() {
        return director;
    }

    @JsonProperty("writer")
    public String getWriter() {
        return writer;
    }

    @JsonProperty("actors")
    public List<String> getActors() {
        if (!(actors == null)) return actors;
        else return new ArrayList<>();
    }

    @JsonProperty("plot")
    public String getPlot() {
        return plot;
    }

    @JsonProperty("language")
    public List<String> getLanguage() {
        if (!(language == null)) return language;
        else return new ArrayList<>();
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("awards")
    public String getAwards() {
        return awards;
    }

    @JsonProperty("poster")
    public String getPoster() {
        return poster;
    }

    @JsonProperty("metascore")
    public String getMetascore() {
        return metascore;
    }

}
