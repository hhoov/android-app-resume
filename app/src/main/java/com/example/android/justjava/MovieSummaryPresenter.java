package com.example.android.justjava;

import android.support.annotation.NonNull;

/**
 * An observer/listener of changes. Presenter for item Views & download progress.
 */
public class MovieSummaryPresenter {
    private MovieSummaryView movieSummaryView = NULL_VIEW;
    private final static MovieSummaryView NULL_VIEW = NullObject.create(MovieSummaryView.class);

    private ProgressProvider progressProvider;
    private String imdbId;
    //private MovieData movieData;

    MovieSummaryPresenter(@NonNull final ProgressProvider progressProvider, final String imdbId) {
        this.progressProvider = progressProvider;
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

    public void onMovieClicked() {
        movieSummaryView.displayMovieDetail(imdbId);
    }

    public void onProgressUpdated(int progress) {
        movieSummaryView.showProgressBar(progress);
    }

    interface MovieSummaryView {

        void displayMovieDetail(String imdbId);
        void showProgressBar(int progress);
        void hideProgressBar();
    }

}