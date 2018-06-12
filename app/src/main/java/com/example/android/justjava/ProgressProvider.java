package com.example.android.justjava;

import android.os.Handler;

import java.util.ArrayList;

/**
 * A subject to observe. Model.
 */
public class ProgressProvider {

    private ArrayList<ProgressPresenter> observersList;
    private boolean changed;
    private ProgressPresenter progressPresenter;

    private int downloadProgress;
    private String fixedMovieID = "tt0108052";
    private String movieID;

    private Handler handler = new Handler();

    ProgressProvider(int downloadProgress) {
        this.downloadProgress = downloadProgress;
        this.movieID = "";
    }

    public int getDownloadProgress() { return downloadProgress; }

    private void setDownloadProgress(int progress) {
        this.downloadProgress = progress;
        setChanged();
        notifyObservers(progressPresenter, downloadProgress);
    }

    private String getMovieID() { return movieID; }

    public void setMovieID(String id) { this.movieID = id; }

    public void runFakeDownloadLoop() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                if (getMovieID().equals(fixedMovieID)) {
                    while (downloadProgress <= 30) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                setDownloadProgress(downloadProgress);

                            }
                        });
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        downloadProgress++;

                    }
                }
            }
        }).start();
    }

    public void registerObserver(ProgressPresenter progressPresenter, String movieID) {
        if (!observersList.contains(progressPresenter)) {
            observersList.add(progressPresenter);
        }
    }

    public void deregisterObserver(ProgressPresenter progressPresenter) {
        observersList.remove(progressPresenter);
    }

    private void notifyObservers(ProgressPresenter progressPresenter, int downloadProgress) {
        //list here?
        if (!hasChanged())
            return;
        // create new list ?
        // clearChanged() ?
        // for each observer in the list, update() ?
        progressPresenter.onProgressUpdated(this, downloadProgress);
    }

    private boolean hasChanged() {
        return changed;
    }

    private void setChanged() {
        changed = true;
    }

}
