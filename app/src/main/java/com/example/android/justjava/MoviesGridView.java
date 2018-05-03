package com.example.android.justjava;

import android.content.Context;

import javax.inject.Inject;

public class MoviesGridView {
    private MyAdapter adapter;

    @Inject
    MoviesGridView(Context context) {

    }

    // todo
    // onResults() & onError() here vs in Presenter?

}
