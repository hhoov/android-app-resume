package com.example.android.justjava;

import android.util.Log;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A subject to observe. Model.
 */
public class ProgressProvider {
    private Map<String, Set<ProgressPresenter>> observerMap = new HashMap<>();
    private static final String FIXED_MOVIE_ID = "tt0108052";
    private int downloadProgress = 0;

    ProgressProvider() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (downloadProgress < 10000) {
                    downloadProgress++;
                    //Log.d("DOWNLOADING -- ", "MovieID " + movieID + " " + downloadProgress);
                    notifyObservers(downloadProgress, FIXED_MOVIE_ID);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
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

    public void registerObserver(String movieID, ProgressPresenter progressPresenter) {
        if (!observerMap.containsKey(movieID)) {
            observerMap.put(movieID, new HashSet<ProgressPresenter>());
        }
        observerMap.get(movieID).add(progressPresenter);
    }

    public void deregisterObserver(String movieID, ProgressPresenter progressPresenter) {
        observerMap.get(movieID).remove(progressPresenter);
        if (!observerMap.get(movieID).contains(progressPresenter)) {
            Log.d("DEREGISTER RESULT"," -- Successful deregister of " + movieID);
        } else {
            Log.d("DEREGISTER RESULT"," -- FAILED to dereg of " + movieID);
        }
    }

    private void notifyObservers(int downloadProgress, String movieID) {
        if (observerMap.containsKey(movieID)) {
            for (ProgressPresenter progressPresenter : observerMap.get(movieID)) {
                progressPresenter.onProgressUpdated(downloadProgress);
            }
        }
    }

}
