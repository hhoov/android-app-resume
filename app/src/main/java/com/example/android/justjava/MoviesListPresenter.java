package com.example.android.justjava;

import javax.inject.Inject;

public class MoviesListPresenter {

    private MoviesListView moviesListView = null;

    @Inject
    public MoviesListPresenter() {

    }

    interface MoviesListView {

    }

}
