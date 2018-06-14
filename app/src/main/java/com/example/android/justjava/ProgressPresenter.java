package com.example.android.justjava;

import android.support.annotation.NonNull;
import android.util.Log;

/**
 * An observer/listener of changes. Presenter for item Views & download progress.
 */
public class ProgressPresenter {
    private ProgressPresenter.ProgressView progressView = NULL_VIEW;
    private final static ProgressPresenter.ProgressView NULL_VIEW = NullObject.create(ProgressPresenter.ProgressView.class);

    private ProgressProvider progressProvider;
    private String movieID;

    ProgressPresenter(@NonNull final ProgressProvider progressProvider, final String movieID) {
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
        progressView.showProgressStatus(downloadProgress);

    }

    public void onProgressUpdated(int progress) {
        progressView.showProgressStatus(progress);
    }

    interface ProgressView {
        void showProgressStatus(int progress);
        void hideProgressStatus();
    }

}