package com.example.android.justjava;

import com.example.android.justjava.model.MovieDetailData;
import com.example.android.justjava.provider.MovieDetailProvider;

import java.io.IOException;
import java.util.concurrent.Executor;

import javax.inject.Inject;

public class MovieDetailPresenter {

    private MovieDetailView movieDetailView = NULL_VIEW;
    private final static MovieDetailView NULL_VIEW = NullObject.create(MovieDetailView.class);

    private MovieDetailProvider movieDetailProvider;
    private final Executor backgroundExecutor;
    private final UIExecutor uiExecutor;

    @Inject MovieDetailPresenter(MovieDetailProvider movieDetailProvider, Executor backgroundExecutor, UIExecutor uiExecutor) {
        this.movieDetailProvider = movieDetailProvider;
        this.backgroundExecutor = backgroundExecutor;
        this.uiExecutor = uiExecutor;
    }

    public void attach(MovieDetailView movieDetailView) {
        this.movieDetailView = movieDetailView;
    }

    public void detach() {
        this.movieDetailView = NULL_VIEW;
    }

    public void present(final String imdbId) {
        backgroundExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    final MovieDetailData movieDetailData = movieDetailProvider.getMovieDetailData(imdbId);
                    uiExecutor.execute(new Runnable() {
                        @Override
                        public void run() {
                            movieDetailView.displayMovieDetails(movieDetailData);
                        }
                    });

                } catch (final IOException e) {
                    uiExecutor.execute(new Runnable() {
                        @Override
                        public void run() {
                            movieDetailView.showError();
                            e.printStackTrace();
                        }
                    });
                }
            }
        });
    }

    interface MovieDetailView {
        void displayMovieDetails(MovieDetailData movieDetailData);
        void showError();
    }
}
