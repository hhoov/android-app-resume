package com.example.android.justjava;

import android.os.Handler;

import com.example.android.justjava.data.MovieDataProvider;
import com.example.android.justjava.model.MovieData;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

public class MoviesPresenter {
    MoviesView view = null;
    private final static MoviesView NULL_VIEW = NullObject.create(MoviesView.class);

    @Inject
    MoviesPresenter() { }

    public void attach(MoviesView view) { this.view = view; }

    public void detach() { this.view = null; }

    public void present() {
        final Handler handler = new Handler();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final List<MovieData> movieData = MovieDataProvider.getInstance().getMovieData();
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

    interface MoviesView {
        void setMovies(List<MovieData> movieDataList);
        void showError();
    }

}
