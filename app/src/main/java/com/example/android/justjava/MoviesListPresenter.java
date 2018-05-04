package com.example.android.justjava;

import android.os.Handler;

import com.example.android.justjava.data.MovieDataProvider;
import com.example.android.justjava.model.MovieData;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

public class MoviesListPresenter {
    private String url = "https://raw.githubusercontent.com/MercuryIntermedia/Sample_Json_Movies/master/top_movies.json";
    private String jsonData;

    final OkhttpSetUp ok;
    private MoviesListView view = NULL_VIEW;
    private final static MoviesListView NULL_VIEW = NullObject.create(MoviesListView.class);

    @Inject
    MoviesListPresenter(OkhttpSetUp ok) {
        this.ok = ok;
    }

    public void attach(MoviesListView view) {
        this.view = view;
    }

    public void detach() {
        this.view = NULL_VIEW;
    }

    public void present() {
        final Handler handler = new Handler();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    jsonData = ok.okhttpHelper(url);
                    final List<MovieData> movieData = MovieDataProvider.getInstance(jsonData).getMovieData();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            view.setMovies(movieData);
                        }
                    });
                } catch (IOException e) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            view.showError();
                        }
                    });
                }
            }
        });
        thread.start();
    }

    interface MoviesListView {
        void setMovies(List<MovieData> movieDataList);
        void showError();
    }

}
