package com.example.android.justjava;

import android.content.Context;

import com.example.android.justjava.model.MovieData;

import java.util.List;

import javax.inject.Inject;

public class MoviesGridView {
    private MyAdapter adapter;

    @Inject
    public MoviesGridView(Context context) {

    }

    public void onResults(List<MovieData> movieDataList) { adapter.setData(movieDataList); }

    public void onError() {
        // todo
    }
}
