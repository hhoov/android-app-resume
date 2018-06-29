package com.example.android.justjava.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class MovieDetailData implements Parcelable {
    private final double imdbRating;
    private final int imdbVotes;
    private final String imdbId;
    private final String title;
    private final int year;
    private final String rated;
    private final String released;
    private final String runtime;

    private final ArrayList<String> genre;

    private final String director;
    private final String writer;

    private final ArrayList<String> actors;
    private final String plot;

    private final ArrayList<String> language;

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
            @JsonProperty("genre") ArrayList<String> genre,
            @JsonProperty("director") String director,
            @JsonProperty("writer") String writer,
            @JsonProperty("actors") ArrayList<String> actors,
            @JsonProperty("plot") String plot,
            @JsonProperty("language") ArrayList<String> language,
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

    public MovieDetailData(Parcel source) {
        imdbRating = source.readDouble();
        imdbVotes = source.readInt();
        imdbId = source.readString();
        title = source.readString();
        year = source.readInt();
        rated = source.readString();
        released = source.readString();
        runtime = source.readString();
        genre = source.createStringArrayList();
        director = source.readString();
        writer = source.readString();
        actors = source.createStringArrayList();
        plot = source.readString();
        language = source.createStringArrayList();
        country = source.readString();
        awards = source.readString();
        poster = source.readString();
        metascore = source.readString();
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

    public ArrayList<String> getGenre(int index) {
        if (!(genre == null)) return genre;
        else return new ArrayList<String>();
    }

    public String getDirector() {
        return director;
    }

    public String getWriter() {
        return writer;
    }

    public ArrayList<String> getActors(int index) {
        if (!(actors == null)) return actors;
        else return new ArrayList<String>();
    }

    public String getPlot() {
        return plot;
    }

    public ArrayList<String> getLanguage(int index) {
        if (!(language == null)) return language;
        else return new ArrayList<String>();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(imdbRating);
        dest.writeInt(imdbVotes);
        dest.writeString(imdbId);
        dest.writeString(title);
        dest.writeInt(year);
        dest.writeString(rated);
        dest.writeString(released);
        dest.writeString(runtime);
        dest.writeStringList(genre);
        dest.writeString(director);
        dest.writeString(writer);
        dest.writeStringList(actors);
        dest.writeString(plot);
        dest.writeStringList(language);
        dest.writeString(country);
        dest.writeString(awards);
        dest.writeString(poster);
        dest.writeString(metascore);
    }

    public static final Creator<MovieDetailData> CREATOR = new Creator<MovieDetailData>() {
        @Override
        public MovieDetailData createFromParcel(Parcel source) {
            return new MovieDetailData(source);
        }

        @Override
        public MovieDetailData[] newArray(int size) {
            return new MovieDetailData[size];
        }
    };

}
