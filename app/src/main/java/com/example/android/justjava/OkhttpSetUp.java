package com.example.android.justjava;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

class OkhttpSetUp implements OkhttpComponent {
    private String jsonData;

    public OkhttpSetUp() {
    }

    public String okhttpHelper(String url) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            Response response = null;
            try {
                response = client.newCall(request).execute();
            } catch (IOException e) {
                e.printStackTrace();
            }

            jsonData = response.body().string();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonData;
    }

    @Override
    public void inject(MoviesGridActivity moviesGridActivity) {

    }

    @Override
    public void inject(MoviesListActivity moviesListActivity) {

    }
}
