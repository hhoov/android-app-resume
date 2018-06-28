package com.example.android.justjava;

import android.support.annotation.NonNull;

/**
 * An observer/listener of changes. Presenter for item Views & download progress.
 */
public class MovieSummaryPresenter {
    private MovieSummaryView movieSummaryView = NULL_VIEW;
    private final static MovieSummaryView NULL_VIEW = NullObject.create(MovieSummaryView.class);

    private ProgressProvider progressProvider;
    private String movieID;

    MovieSummaryPresenter(@NonNull final ProgressProvider progressProvider, final String movieID) {
        this.progressProvider = progressProvider;
        this.movieID = movieID;
    }

    public void attach(MovieSummaryView movieSummaryView) {
        // set visibility of the download view here.
        this.movieSummaryView = movieSummaryView;
        this.progressProvider.registerObserver(movieID, this);
    }

    public void detach() {
        this.movieSummaryView = NULL_VIEW;
        progressProvider.deregisterObserver(movieID, this);
    }

    public void present() {
        int downloadProgress = progressProvider.getDownloadProgress(movieID);
        movieSummaryView.showProgressBar(downloadProgress);

    }

    public void onProgressUpdated(int progress) {
        movieSummaryView.showProgressBar(progress);
    }

    interface MovieSummaryView {
        void showProgressBar(int progress);
        void hideProgressBar();
    }

}