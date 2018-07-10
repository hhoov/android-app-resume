package com.example.android.justjava;

import com.example.android.justjava.model.MovieSummaryData;
import com.example.android.justjava.provider.MovieSummaryProvider;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

public class MoviesPresenter {
    public MoviesView view = NULL_VIEW;
    private final static MoviesView NULL_VIEW = NullObject.create(MoviesView.class);

    private final MovieSummaryProvider movieSummaryProvider;
    private final Executor backgroundExecutor;
    private final UIExecutor uiExecutor;

    @Inject MoviesPresenter(MovieSummaryProvider movieSummaryProvider, Executor backgroundExecutor, UIExecutor uiExecutor) {
        this.movieSummaryProvider = movieSummaryProvider;
        this.backgroundExecutor = backgroundExecutor;
        this.uiExecutor = uiExecutor;
    }

    public void attach(MoviesView view) { this.view = view; }

    public void detach() { this.view = NULL_VIEW; }

    public void present() {
        backgroundExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    final List<MovieSummaryData> movieSummaryData = movieSummaryProvider.getMovieData();
                    uiExecutor.execute(new Runnable() {
                        @Override
                        public void run() {
                            view.setMovies(movieSummaryData);
                        }
                    });
                } catch (IOException e) {
                    uiExecutor.execute(new Runnable() {
                        @Override
                        public void run() {
                            view.showError();
                        }
                    });
                }
            }
        });
    }

    interface MoviesView {
        void setMovies(List<MovieSummaryData> movieSummaryDataList);
        void showError();
    }

}
