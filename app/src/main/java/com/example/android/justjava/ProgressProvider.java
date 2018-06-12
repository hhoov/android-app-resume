package com.example.android.justjava;

import android.os.Handler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A subject to observe. Model.
 */
public class ProgressProvider {
    private Handler handler = new Handler();
    private Map<String, Set<ProgressPresenter>> observerMap = new HashMap<>();
    private static final String FIXED_MOVIE_ID = "tt0108052";

    private int downloadProgress = 0;

    ProgressProvider() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (downloadProgress < 30) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            setDownloadProgress(downloadProgress++);
                        }
                    });
                } else {
                    downloadProgress = 0;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public int getDownloadProgress(String movieID) {
        if (movieID.equals(FIXED_MOVIE_ID)) {
            return downloadProgress;
        } else {
            return 0;
        }
    }

    private void setDownloadProgress(int progress) {
        downloadProgress = progress;
        notifyObservers(downloadProgress);
    }

    public void registerObserver(ProgressPresenter progressPresenter, String movieID) {
        if (!observerMap.containsKey(movieID)) {
            observerMap.put(movieID, new HashSet<ProgressPresenter>());
        }
        observerMap.get(movieID).add(progressPresenter);
    }

    public void deregisterObserver(ProgressPresenter progressPresenter, String movieID) {
        observerMap.get(movieID).remove(progressPresenter);
    }

    private void notifyObservers(int downloadProgress) {
        for (ProgressPresenter progressPresenter : observerMap.get(FIXED_MOVIE_ID)) {
            progressPresenter.onProgressUpdated(downloadProgress);
        }
    }

}
