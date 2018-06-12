package com.example.android.justjava;

import android.support.annotation.NonNull;

/**
 * An observer/listener of changes. Presenter for item Views & download progress.
 */
public class ProgressPresenter {
    private ProgressPresenter.ProgressView progressView = NULL_VIEW;
    private final static ProgressPresenter.ProgressView NULL_VIEW = NullObject.create(ProgressPresenter.ProgressView.class);

    private ProgressProvider progressProvider;
    private String movieID;
    private int downloadProgress;

    ProgressPresenter(@NonNull final ProgressProvider progressProvider, final String movieID) {
        this.progressProvider = progressProvider;
        this.movieID = movieID;
    }

    public void attach(ProgressView progressView) {
        // set visibility of the download view here.
        this.progressView = progressView;
        this.progressProvider.registerObserver(this, movieID);
    }

    public void detach() {
        progressProvider.deregisterObserver(this);
        this.progressView = NULL_VIEW;
    }

    public void present() {
        downloadProgress = progressProvider.getDownloadProgress();
        progressView.showProgressStatus(downloadProgress);
        progressProvider.runFakeDownloadLoop();
    }

    // Called when observed object is changed. Observable object's observers are notified of the change
    // through notifyObservers().
    public void onProgressUpdated(ProgressProvider progressProvider, int progress) {
        // If subscribed, calls showProgressStatus() on view.
        progressView.showProgressStatus(progress);


    }

    interface ProgressView {
        void showProgressStatus(int progress);
        // hideProgressStatus() should go into onViewRecycled() perhaps
        // onRecycled()/handling of what's currently in view/what's recycled/what's destroyed here in hideProgressStatus()?
        void hideProgressStatus();
    }

}