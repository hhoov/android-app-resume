package com.example.android.justjava;

/**
 * An observer of changes. Presenter for item Views & download progress.
 */
public class ItemViewsPresenter implements MyObserver {

    private int mProgress;
    // A reference to our associated observable model
    private MyObservable observableValue;

    ItemViewsPresenter(MyObservable observableVal) {
        this.observableValue = observableVal;
        mProgress = 0;
        System.out.println("ItemViewsPresenter observer created: " + mProgress);
    }

    //public void attach(ProgressView view) { this.view = view; }
    //public void detach() { this.view = NULL_VIEW; }

    /**
     * Called when observed object is changed. Observable object's observers are notified of the change
     * through notifyObservers().
     * //@param observableCurrentProgress the observable object
     * //@param arg should be the identifier for which movie's progress is being updated...?
     */
    public void onDownloadProgressUpdated() {
        /*
          Checking to see if the specified observable is listed in the Observers list?
          if so, getting progress.
          or
          if (arg instanceof String) {
              mProgress = observableValue.getDownloadProgress();
          }

          Movie msg = (String) observableValue.getUpdate(this);
          if(msg == null) { }

          if changed and subscribed, call showProgressStatus to update the view
          if no longer subscribed, hideProgressStatus to update the view
        */
    }

    // Item views presenter
    // For every second that it's subscribed, get update of progress (but this occurs in the provider
    //  in the fake loop, yes?)
    // register() will call onDownloadProgressUpdated() //update()
    public void present() {
        // Needs to poll the view to see if movieID that is to be downloaded is in View
        // if it is in view, or rather at the very start (?), should start/continue fakeLoop
        // each time it appears in view, getDownloadProgress ? only if it's got an observer subscribed
        // perhaps this is where the register/unregister/etc occurs? depending on results of view poll
        // onRecycled() is important to see if current view has been recycled/to decide to unregister
    }

    interface ProgressView {
        //boolean returnPoll();
        void showProgressStatus();
        void hideProgressStatus();
    }

}