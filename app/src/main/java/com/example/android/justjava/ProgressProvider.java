package com.example.android.justjava;

import java.util.Observable;

/**
 * A subject to observe.
 */
public class ProgressProvider extends Observable {

    // The model
    private int progress;

    ProgressProvider(int progress) {
        this.progress = progress;
        System.out.println("ProgressProvider subject created: " + progress);
    }

    public void setProgress(int progress) {
        this.progress = progress;
        setChanged();
        notifyObservers(progress);
    }

    public int getProgress() {
        return progress;
    }


}
