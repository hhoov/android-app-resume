package com.example.android.justjava.data;

import com.example.android.justjava.ApplicationComponent;
import com.example.android.justjava.JSONParser;
import com.example.android.justjava.MyApplication;
import com.example.android.justjava.model.MovieData;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MovieDataProvider {
    private static MovieDataProvider singletonInstance;
    private String jsonData;
    private String url = "https://raw.githubusercontent.com/MercuryIntermedia/Sample_Json_Movies/master/top_movies.json";
    private JSONParser parser = new JSONParser();

    @Singleton
    @Inject
    OkHttpClient okHttpClient;

    // Private constructor prevents any other class from instantiating.
    private MovieDataProvider() {
        MyApplication.getApplicationComponent().inject(this);
    }

    // Static instance method
    // If no singleton instance, creates new singleton instance with attrib response string
    public static MovieDataProvider getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new MovieDataProvider();
        }
        return singletonInstance;
    }

    // Call readJsonStream with response string arg on JSONParser object
    public List<MovieData> getMovieData() throws IOException {
        jsonData = makeRequest(url);
        return parser.readJsonStream(jsonData);
    }

    private String makeRequest(String url) {

        try {
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            Response response = null;
            try {
                response = okHttpClient.newCall(request).execute();
            } catch (IOException e) {
                e.printStackTrace();
            }

            jsonData = response.body().string();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonData;
    }

}
