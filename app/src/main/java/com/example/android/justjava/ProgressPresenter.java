package com.example.android.justjava;

/**
 * An observer/listener of changes. Presenter for item Views & download progress.
 */
public class ProgressPresenter implements MyObserver {
    private ProgressPresenter.ProgressView progressView = NULL_VIEW;
    private final static ProgressPresenter.ProgressView NULL_VIEW = NullObject.create(ProgressPresenter.ProgressView.class);

    private ProgressProvider progressProvider;

    ProgressPresenter(ProgressProvider progressProvider) {
        this.progressProvider = progressProvider;
        this.progressProvider.registerObserver(this);
    }

    public void attach(ProgressView progressView) {
        // set visibility of the download view here.
        this.progressView = progressView;
    }

    public void detach() {
        if (progressProvider != null) {
            progressProvider.deregisterObserver(this);
        }
        this.progressView = NULL_VIEW;
    }

    /**
     * Called when observed object is changed. Observable object's observers are notified of the change
     * through notifyObservers().
     * @param myObservable      the observable object
     * @param progress          the updated progress data
     */
    public void onProgressUpdated(MyObservable myObservable, Object progress) {
        // Checks if the specified observable object is an instance of ProgressProvider
        // If subscribed, calls showProgressStatus() on view.
        if (myObservable instanceof ProgressProvider) {
            progressProvider = (ProgressProvider) myObservable;
            //progress = progressProvider.getDownloadProgress();
            progressView.showProgressStatus((int)progress);

        }
            // Don't need else statement here because
            // notify and update will not be called on an object that is not subscribed, because it goes through the updated
            // list every time. thus, hideProgressStatus really should go wherever the check is for whether the observable
            // is in the view/is subscribed to by the observer (the view is the observer).
            //progressView.hideProgressStatus();
    }

    interface ProgressView {
        // onRecycled()/handling of what's currently in view/what's recycled/what's destroyed here?
        void setItemView();
        void showProgressStatus(int progress);
        void hideProgressStatus();
    }

}