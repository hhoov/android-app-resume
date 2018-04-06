package com.example.android.justjava;

public class MovieData {

    private String[] title;
    private int imageURL;

    public MovieData(String[] title, int imageURL) {
        this.title = title;
        this.imageURL = imageURL;
    }

    public String[] getTitle() {
        return title;
    }

    public int getImageURL() {
        return imageURL;
    }
}
