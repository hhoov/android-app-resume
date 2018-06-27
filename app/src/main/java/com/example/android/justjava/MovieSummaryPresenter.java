package com.example.android.justjava;

import android.support.annotation.NonNull;

/**
 * An observer/listener of changes. Presenter for item Views & download progress.
 */
public class MovieSummaryPresenter {
    private MovieSummaryPresenter.ProgressView progressView = NULL_VIEW;
    private final static MovieSummaryPresenter.ProgressView NULL_VIEW = NullObject.create(MovieSummaryPresenter.ProgressView.class);

    private ProgressProvider progressProvider;
    private String movieID;

    MovieSummaryPresenter(@NonNull final ProgressProvider progressProvider, final String movieID) {
        this.progressProvider = progressProvider;
        this.movieID = movieID;
    }

    public void attach(ProgressView progressView) {
        // set visibility of the download view here.
        this.progressView = progressView;
        this.progressProvider.registerObserver(movieID, this);
    }

    public void detach() {
        this.progressView = NULL_VIEW;
        progressProvider.deregisterObserver(movieID, this);
    }

    public void present() {
        int downloadProgress = progressProvider.getDownloadProgress(movieID);
        progressView.showProgressBar(downloadProgress);

    }

    public void onProgressUpdated(int progress) {
        progressView.showProgressBar(progress);
    }

    interface ProgressView {
        void showProgressBar(int progress);
        void hideProgressBar();
    }

}