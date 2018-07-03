package com.example.android.justjava;

import com.example.android.justjava.model.MovieDetailData;
import com.example.android.justjava.provider.MovieDetailDataProvider;

import java.io.IOException;
import java.util.concurrent.Executor;

import javax.inject.Inject;

public class MovieDetailPresenter {

    private MovieDetailView movieDetailView = NULL_VIEW;
    private final static MovieDetailView NULL_VIEW = NullObject.create(MovieDetailView.class);

    private MovieDetailDataProvider movieDetailDataProvider;
    private final Executor backgroundExecutor;
    private final UIExecutor uiExecutor;

    @Inject MovieDetailPresenter(MovieDetailDataProvider movieDetailDataProvider, Executor backgroundExecutor, UIExecutor uiExecutor) {
        this.movieDetailDataProvider = movieDetailDataProvider;
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
                    final MovieDetailData movieDetailData = movieDetailDataProvider.getMovieDetailData(imdbId);
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
