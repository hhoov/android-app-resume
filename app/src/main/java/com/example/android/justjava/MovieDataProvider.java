package com.example.android.justjava;

import java.io.IOException;
import java.util.List;

public class MovieDataProvider {
    private static MovieDataProvider singletonInstance;
    private final String response;
    private JSONParser parser = new JSONParser();

    // Private constructor prevents any other class from instantiating.
    private MovieDataProvider(String response) {
        this.response = response;
    }

    // Static instance method
    public static MovieDataProvider getInstance(String response) {
        if (singletonInstance == null) {
            singletonInstance = new MovieDataProvider(response);
        }
        return singletonInstance;
    }

    // Start thread that populates list
    public List<MovieData> getMovieData() throws IOException {
        return parser.readJsonStream(response);
    }

}
