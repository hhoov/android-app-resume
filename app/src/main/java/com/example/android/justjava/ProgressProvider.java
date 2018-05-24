package com.example.android.justjava;

import java.util.Observable;

public class ProgressProvider extends Observable {

    private int progress;

    ProgressProvider(int progress) {
        this.progress = progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
        setChanged();
        notifyObservers();
    }

    public int getProgress() {
        return progress;
    }


}
