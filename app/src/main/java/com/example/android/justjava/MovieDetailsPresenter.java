package com.example.android.justjava;

import com.example.android.justjava.model.MovieDetailData;
import com.example.android.justjava.provider.MovieDetailDataProvider;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

public class MovieDetailsPresenter {
    public MovieDetailsView view = NULL_VIEW;
    private final static MovieDetailsView NULL_VIEW = NullObject.create(MovieDetailsView.class);

    private final MovieDetailDataProvider movieDetailDataProvider;
    private final Executor backgroundExecutor;
    private final UIExecutor uiExecutor;

    @Inject MovieDetailsPresenter(MovieDetailDataProvider movieDetailDataProvider, Executor backgroundExecutor, UIExecutor uiExecutor) {
        this.movieDetailDataProvider = movieDetailDataProvider;
        this.backgroundExecutor = backgroundExecutor;
        this.uiExecutor = uiExecutor;
    }

    public void attach(MovieDetailsView view) { this.view = view; }

    public void detach() { this.view = NULL_VIEW; }

    public void present() {
        backgroundExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    final List<MovieDetailData> movieDetailData = movieDetailDataProvider.getMovieDetailData();
                    uiExecutor.execute(new Runnable() {
                        @Override
                        public void run() {
                            view.setMovieDetails(movieDetailData);
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

    interface MovieDetailsView {
        void setMovieDetails(List<MovieDetailData> movieDetailDataList);
        void showError();
    }

}
