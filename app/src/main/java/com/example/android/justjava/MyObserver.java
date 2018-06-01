package com.example.android.justjava;

public interface MyObserver {
    /**
     * Called whenever the observed object is changed. An application calls an observable object's
     * notifyObservers method to have all the object's observers notified of the change.
     * //@param currentProgress   the observable object.
     * //@param movieIdentifier   the identifier for which movie's progress is being updated.
     */
    void onProgressUpdated(MyObservable myObservable, Object progress);
}
