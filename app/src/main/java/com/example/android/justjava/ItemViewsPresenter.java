package com.example.android.justjava;

import com.example.android.justjava.model.MovieData;

import java.util.Observable;

/**
 * An observer of progressView changes.
 */
public class ProgressPresenter implements MyObserver {

    //public ProgressView view = NULL_VIEW;
    //private final static ProgressView NULL_VIEW = NullObject.create(ProgressView.class);
    // The view.
    private int progressView;
    // A reference to our associated observable model
    private ProgressProvider observableValue;

    ProgressPresenter(ProgressProvider observableVal) {
        this.observableValue = observableVal;
        progressView = 0;
        System.out.println("ProgressPresenter observer created: " + progressView);
    }

    /*public void attach(ProgressView view) { this.view = view; }

    public void detach() { this.view = NULL_VIEW; }*/

    //@Override
    public void downloadProgressChanged(Observable observable, Object arg) {

        if (observable == observableValue) System.out.println(String.valueOf(observableValue.getProgress()));

    }

    @Override
    public void downloadProgressChanged(MyObservable currentProgress, MovieData movieIdentifier) {
        //if (observable == observableValue) System.out.println(String.valueOf(observableValue.getProgress()));

    }

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