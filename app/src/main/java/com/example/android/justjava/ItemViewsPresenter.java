package com.example.android.justjava;

/**
 * An observer/listener of changes. Presenter for item Views & download progress.
 */
public class ItemViewsPresenter implements MyObserver {
    private ProgressProvider progressProvider; // perhaps this is needed if I implement .getInstance() singleton?
    private ProgressView progressView;
    // A reference to our associated observable model
    private MyObservable subjectProgress;

    ItemViewsPresenter(MyObservable myObservable) {
        this.subjectProgress = myObservable;
        this.subjectProgress.registerObserver(this);
    }

    //public void attach(ProgressView view) { this.view = view; }
    //public void detach() { this.view = NULL_VIEW; }

    /**
     * Called when observed object is changed. Observable object's observers are notified of the change
     * through notifyObservers().
     * //@param observableCurrentProgress the observable object
     * //@param arg should be the identifier for which movie's progress is being updated...?
     */
    public void onProgressUpdated(MyObservable myObservable, int progress) {
        // Checks if the specified observable object is an instance of ProgressProvider
        if (myObservable instanceof ProgressProvider) {
            ProgressProvider progressProvider = (ProgressProvider) myObservable;
            progress = progressProvider.getDownloadProgress();
            // return progress to present() ? to update view with new progress ?
            // presenter called here to check if view includes the object that's been changed
            // or have a check in present() that sees if the progress variable has
            // changed/if this method has been called?

        }

        /*
          ?
          if changed and subscribed, call showProgressStatus to update the view
          if no longer subscribed, hideProgressStatus to update the view
        */
    }

    // Item views presenter
    // For every second that it's subscribed, get update of progress (but this occurs in the provider
    //  in the fake loop, yes?)
    // register() will call onProgressUpdated() //update()
    public void present() {
        // Needs to poll the view to see if movieID that is to be downloaded is in View
        // if it is in view, or rather at the very start (?), should start/continue fakeLoop
        // through ProgressProvider.
        // each time it appears in view, getDownloadProgress ? only if it's got an observer subscribed
        // perhaps this is where the register/unregister/etc occurs? depending on results of view poll
        // onRecycled() is important to see if current view has been recycled/to decide to unregister
        //
    }

    interface ProgressView {
        // onRecycled()/handling of what's currently in view/what's recycled/what's destroyed here?
        // boolean returnPoll();
        // setProgressOfCurrentView()
        void showProgressStatus(int progress);
        void hideProgressStatus();
    }

}