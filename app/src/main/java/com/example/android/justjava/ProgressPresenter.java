package com.example.android.justjava;

import java.util.Observable;
import java.util.Observer;

public class ProgressPresenter implements Observer {

    public ProgressView view = NULL_VIEW;
    private final static ProgressView NULL_VIEW = NullObject.create(ProgressView.class);

    private ProgressProvider observableValue;

    ProgressPresenter(ProgressProvider observableVal) {
        this.observableValue = observableVal;
    }

    public void attach(ProgressView view) { this.view = view; }

    public void detach() { this.view = NULL_VIEW; }

    @Override
    public void update(Observable observable, Object arg) {

        if (observable == observableValue) System.out.println(String.valueOf(observableValue.getProgress()));

    }

    // View should be the Observer, I think
    interface ProgressView {

    }

}