package com.example.android.justjava;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

class OkhttpSetUp {
    private String jsonData;
    private final OkHttpClient okHttpClient;
    @Inject
    public OkhttpSetUp(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    public String okhttpHelper(String url) {
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
