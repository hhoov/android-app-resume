package com.example.android.justjava;

import com.example.android.justjava.model.MovieData;

public interface ObserverProgress {
    /**
     * Called whenever the observed object is changed. To have all the object's observers notified
     * of the change, the application calls an ObservableProgress object's notifyObservers method.
     * @param currentProgress   the observable object.
     * @param movieIdentifier   the identifier for which movie's progress is being updated.
     */
    void downloadProgressChanged(ObservableProgress currentProgress, MovieData movieIdentifier);
}
