package com.example.android.justjava;

public class MovieData {

    private int rank;
    public String title;
    private int year;
    private String imdbId;
    private double imdbRating;
    private int imdbVotes;
    private String poster;
    private String imdbLink;
    public String imageURL;

    MovieData(int rank, String title, int year, String imdbId, double imdbRating, int imdbVotes, String poster, String imdbLink) {
        this.rank = rank;
        this.title = title;
        this.year = year;
        this.imdbId = imdbId;
        this.imdbRating = imdbRating;
        this.imdbVotes = imdbVotes;
        this.poster = poster;
        this.imdbLink = imdbLink;
        this.imageURL = imageURL;

    }

}
