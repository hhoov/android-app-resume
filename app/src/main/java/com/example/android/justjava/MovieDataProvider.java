package com.example.android.justjava;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static com.example.android.justjava.R.raw.top_movies;

public class MovieDataProvider {
    private static MovieDataProvider singletonInstance;
    private final Context context;
    private JSONParser parser = new JSONParser();

    // Private constructor prevents any other class from instantiating.
    private MovieDataProvider(Context context) {
        this.context = context;
    }

    // Static instance method
    public static MovieDataProvider getInstance(Context context) {
        if (singletonInstance == null) {
            singletonInstance = new MovieDataProvider(context);
        }
        return singletonInstance;
    }

    // Start thread that populates list
    public List<MovieData> getMovieData() throws IOException {
        InputStream is = context.getResources().openRawResource(top_movies);
        return parser.readJsonStream(is);
    }

}
