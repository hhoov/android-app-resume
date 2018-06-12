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
    //private Handler handler = new Handler();
    private Map<String, Set<ProgressPresenter>> observerMap = new HashMap<>();
    private static final String FIXED_MOVIE_ID = "tt0108052";
    private int downloadProgress = 0;

    ProgressProvider(final String movieID) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (downloadProgress < 30 && movieID.equals(FIXED_MOVIE_ID)) {
                    //handler.post(new Runnable() {
                    //    @Override
                   //     public void run() {
                            //setDownloadProgress(downloadProgress++);
                        //}
                   // });
                    downloadProgress++;
                }
                // todo: need to handle when observed movie reaches complete download
                // todo: need to handle checking if movieID is currently observed, whether to ++ or set = 0
                else if (downloadProgress == 30 && movieID.equals(FIXED_MOVIE_ID)) {
                    return;
                }

                else {
                    downloadProgress = 0;
                }

                if (!observerMap.isEmpty()) {
                    for (ProgressPresenter progressPresenter : observerMap.get(FIXED_MOVIE_ID)) {
                        progressPresenter.onProgressUpdated(downloadProgress);
                    }
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

    public void registerObserver(String movieID, ProgressPresenter progressPresenter) {
        if (observerMap.isEmpty()) {
            observerMap.put(movieID, new HashSet<ProgressPresenter>());
        }
        if (!observerMap.containsKey(movieID)) {
            observerMap.put(movieID, new HashSet<ProgressPresenter>());
        }
        observerMap.get(movieID).add(progressPresenter);
    }

    public void deregisterObserver(String movieID, ProgressPresenter progressPresenter) {
        observerMap.get(movieID).remove(progressPresenter);
    }

    private void notifyObservers(int downloadProgress) {
        for (ProgressPresenter progressPresenter : observerMap.get(FIXED_MOVIE_ID)) {
            progressPresenter.onProgressUpdated(downloadProgress);
        }
    }

}
