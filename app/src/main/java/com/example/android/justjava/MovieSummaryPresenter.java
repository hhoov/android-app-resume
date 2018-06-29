package com.example.android.justjava;

import android.support.annotation.NonNull;

import com.example.android.justjava.model.MovieDetailData;
import com.example.android.justjava.provider.MovieDetailDataProvider;

import java.io.IOException;

import javax.inject.Inject;

/**
 * An observer/listener of changes. Presenter for item Views & download progress.
 */
public class MovieSummaryPresenter {
    private MovieSummaryView movieSummaryView = NULL_VIEW;
    private final static MovieSummaryView NULL_VIEW = NullObject.create(MovieSummaryView.class);

    private ProgressProvider progressProvider;
    private MovieDetailDataProvider movieDetailDataProvider;
    private String imdbId;

    MovieSummaryPresenter(@NonNull final ProgressProvider progressProvider, final String imdbId) {
        this.progressProvider = progressProvider;
        this.imdbId = imdbId;

    }
    @Inject
    MovieSummaryPresenter(MovieDetailDataProvider movieDetailDataProvider, final String imdbId) {
        this.movieDetailDataProvider = movieDetailDataProvider;
        this.imdbId = imdbId;
    }

    public void attach(MovieSummaryView movieSummaryView) {
        // set visibility of the download view here.
        this.movieSummaryView = movieSummaryView;
        this.progressProvider.registerObserver(imdbId, this);
    }

    public void detach() {
        this.movieSummaryView = NULL_VIEW;
        progressProvider.deregisterObserver(imdbId, this);
    }

    public void present() {
        int downloadProgress = progressProvider.getDownloadProgress(imdbId);
        movieSummaryView.showProgressBar(downloadProgress);
    }

    public void onMovieClicked() throws IOException {
        MovieDetailData movieDetailData = movieDetailDataProvider.getMovieDetailData(imdbId);
        movieSummaryView.displayMovieDetail(movieDetailData);
    }

    public void onProgressUpdated(int progress) {
        movieSummaryView.showProgressBar(progress);
    }

    interface MovieSummaryView {

        void displayMovieDetail(MovieDetailData movieDetailData);
        void showProgressBar(int progress);
        void hideProgressBar();
    }

}