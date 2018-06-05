package com.example.android.justjava;

import android.os.Handler;

/**
 * A subject to observe. Model.
 */
public class ProgressProvider extends MyObservable {

    private int downloadProgress = 0;
    private String fixedMovieID = "tt0108052";
    private String movieID;

    private Handler handler = new Handler();

    ProgressProvider(int downloadProgress) {
        setMovieID("tt0108052");
        this.downloadProgress = downloadProgress;
    }

    public int getDownloadProgress() { return downloadProgress; }

    private void setDownloadProgress(int progress) {
        this.downloadProgress = progress;
        setChanged();
        notifyObservers(downloadProgress);
    }

    public String getMovieID() { return movieID; }

    private void setMovieID(String id) { this.movieID = id; }

    public void runFakeDownloadLoop() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                if (fixedMovieID.contains(movieID)) {
                    while (downloadProgress <= 100) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                setDownloadProgress(downloadProgress);
                                //txtProgress.setText(String.format(String.valueOf(downloadProgress), "%d %%"));

                            }
                        });
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        downloadProgress++;
                    }
                } else {
                    setDownloadProgress(0);
                }
            }
        }).start();
    }

}
