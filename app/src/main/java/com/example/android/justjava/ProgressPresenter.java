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
            //progress = progressProvider.getDownloadProgress(); ? not needed because argument progress is passed already
            progressView.showProgressStatus((int)progress);

        }
    }

    interface ProgressView {
        void setItemView();
        void showProgressStatus(int progress);
        // hideProgressStatus() should go into onViewRecycled() perhaps
        // onRecycled()/handling of what's currently in view/what's recycled/what's destroyed here in hideProgressStatus()?
        void hideProgressStatus();
    }

}