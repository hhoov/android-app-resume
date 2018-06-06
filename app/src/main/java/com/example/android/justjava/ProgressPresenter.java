package com.example.android.justjava;

/**
 * An observer/listener of changes. Presenter for item Views & download progress.
 */
public class ProgressPresenter implements MyObserver {
    private ProgressPresenter.ProgressView progressView = NULL_VIEW;
    private final static ProgressPresenter.ProgressView NULL_VIEW = NullObject.create(ProgressPresenter.ProgressView.class);

    private ProgressProvider progressProvider;
    private int progress;

    ProgressPresenter(ProgressProvider progressProvider) {
        this.progressProvider = progressProvider;
        this.progressProvider.registerObserver(this);
        progress = progressProvider.getDownloadProgress();
        progressView.showProgressStatus(progress);
    }

    public void attach(ProgressView progressView) { this.progressView = progressView; }

    public void detach() { this.progressView = NULL_VIEW; }

    // Item views presenter
    // For every second that it's subscribed, get update of progress (but this occurs in the provider
    //  in the fake loop, yes?)
    // register() will call onProgressUpdated() //update()
    public void present(String movieID) {
        while (progressProvider.countObservers() != 0) {
            progress = progressProvider.getDownloadProgress();
            progressView.showProgressStatus(progress);
            // Needs to poll the view to see if movieID that is to be downloaded is in View
            // if it is in view, or rather at the very start (?), should start/continue fakeLoop
            // through ProgressProvider.
            // each time it appears in view, getDownloadProgress ? only if it's got an observer subscribed
            // perhaps this is where the register/unregister/etc occurs? depending on results of view poll
            // onRecycled() is important to see if current view has been recycled/to decide to unregister
            //

            // if adapter's movieID == provider.getMovieID(), then onProgressUpdated( observable, progress)
            // else set progress to 0.
        }

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



            // return progress to present() ? to update view with new progress ?
            // presenter called here to check if view includes the object that's been changed
            // or have a check in present() that sees if the progress variable has
            // changed/if this method has been called?
        }
            // Don't need else statement here because
            // notify and update will not be called on an object that is not subscribed, because it goes through the updated
            // list every time. thus, hideProgressStatus really should go wherever the check is for whether the observable
            // is in the view/is subscribed to by the observer (the view is the observer).
            //progressView.hideProgressStatus();
    }

    interface ProgressView {
        // onRecycled()/handling of what's currently in view/what's recycled/what's destroyed here?
        // boolean returnPoll();
        void setItemView();
        void showProgressStatus(int progress);
        void hideProgressStatus();
    }

}