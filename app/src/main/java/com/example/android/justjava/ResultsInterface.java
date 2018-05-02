package com.example.android.justjava;

import com.example.android.justjava.model.MovieData;

import java.util.List;

public interface ResultsInterface {
    void onResults(List<MovieData> movieList);

    void onError();
}
