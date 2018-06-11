package com.example.android.justjava;

import android.os.Handler;

/**
 * A subject to observe. Model.
 */
public class ProgressProvider extends MyObservable {

    private int downloadProgress;
    private String fixedMovieID = "tt0108052";
    private String movieID;

    private Handler handler = new Handler();

    ProgressProvider(int downloadProgress) {
        this.downloadProgress = downloadProgress;
    }

    public int getDownloadProgress() { return downloadProgress; }

    private void setDownloadProgress(int progress) {
        this.downloadProgress = progress;
        setChanged();
        notifyObservers(downloadProgress);
    }

    public String getMovieID() { return movieID; }

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

                        if (downloadProgress == 100) {
                            break;
                        }
                    }
                }
            }
        }).start();
    }

}
