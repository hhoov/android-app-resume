package com.example.android.justjava;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Singleton
class OkhttpHelper {

    private final OkHttpClient okHttpClient;

    @Inject
    OkhttpHelper(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    public String makeRequest(String url) {
        String jsonData = "";
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
