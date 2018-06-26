package com.example.android.justjava.provider;

import com.example.android.justjava.JSONParser;
import com.example.android.justjava.model.MovieDetailData;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Singleton
public class MovieDetailDataProvider {
    private String jsonData;
    private String url = "https://raw.githubusercontent.com/MercuryIntermedia/Sample_Json_Movies/35cccb4bb96bc00575f34ab49bb0f56bf7c77f0e/by_id/tt0035575.json";
    private JSONParser parser = new JSONParser();

    private final OkHttpClient okHttpClient;

    // Private constructor prevents any other class from instantiating.
    @Inject
    MovieDetailDataProvider(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    // Call readDetailJsonStream with response string arg on JSONParser object
    public List<MovieDetailData> getMovieDetailData() throws IOException {
        jsonData = makeRequest(url);
        return parser.readDetailJsonStream(jsonData);
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
