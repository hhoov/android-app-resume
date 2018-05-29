package com.example.android.justjava;

import java.util.Observable;
import java.util.Observer;

/**
 * An observer of progressView changes. Presenter for movie item views.
 */
public class ItemViewsPresenter implements Observer {

    //public ProgressView view = NULL_VIEW;
    //private final static ProgressView NULL_VIEW = NullObject.create(ProgressView.class);
    // The view.
    private int progressView;
    // A reference to our associated observable model
    private ProgressProvider observableValue;

    ItemViewsPresenter(ProgressProvider observableVal) {
        this.observableValue = observableVal;
        progressView = 0;
        System.out.println("ItemViewsPresenter observer created: " + progressView);
    }

    /*public void attach(ProgressView view) { this.view = view; }

    public void detach() { this.view = NULL_VIEW; }*/

    public void update(Observable obj, Object arg) {
        if (arg instanceof String) {
            progressView = (int) arg;
            System.out.println("ProgPresenter observer: Progress changed to " + progressView);
        } else {
            System.out.println("ProgPresenter observer: Some other change to subject occurred.");
        }
    }

    // View should be the Observer, I think
    interface ProgressView {
        void showProgressStatus();
        void hideProgressStatus();
    }

}