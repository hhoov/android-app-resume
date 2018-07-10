package com.example.android.justjava.provider;

import com.example.android.justjava.JSONParser;
import com.example.android.justjava.model.MovieDetailData;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Singleton
public class MovieDetailProvider {
    private String jsonData;
    private String url = "https://raw.githubusercontent.com/MercuryIntermedia/Sample_Json_Movies/master/by_id/";
    private JSONParser parser = new JSONParser();

    private final OkHttpClient okHttpClient;

    // Private constructor prevents any other class from instantiating.
    @Inject
    MovieDetailProvider(OkHttpClient okHttpClient) { this.okHttpClient = okHttpClient; }

    // Call readDetailJsonStream with response string arg on JSONParser object
    public MovieDetailData getMovieDetailData(String imdbId) throws IOException {
        String urlExtension = ".json";
        String urlWithImdbId = url + imdbId + urlExtension;
        jsonData = makeRequest(urlWithImdbId);
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
