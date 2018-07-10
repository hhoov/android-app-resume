package com.example.android.justjava;

import android.os.Handler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A subject to observe.
 */
public class ProgressProvider {
    private static final String FIXED_MOVIE_ID = "tt0108052";
    private Map<String, Set<MovieSummaryPresenter>> observerMap = new HashMap<>();
    private int downloadProgress = 0;
    private Handler handler = new Handler();

    ProgressProvider() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (downloadProgress < 100) {
                    downloadProgress++;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            notifyObservers(downloadProgress, FIXED_MOVIE_ID);
                        }
                    });

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

    public void registerObserver(String movieID, MovieSummaryPresenter movieSummaryPresenter) {
        if (!observerMap.containsKey(movieID)) {
            observerMap.put(movieID, new HashSet<MovieSummaryPresenter>());
        }
        observerMap.get(movieID).add(movieSummaryPresenter);
    }

    public void deregisterObserver(String movieID, MovieSummaryPresenter movieSummaryPresenter) {
        observerMap.get(movieID).remove(movieSummaryPresenter);
    }

    private void notifyObservers(int downloadProgress, String movieID) {
        if (observerMap.containsKey(movieID)) {
            for (MovieSummaryPresenter movieSummaryPresenter : observerMap.get(movieID)) {
                movieSummaryPresenter.onProgressUpdated(downloadProgress);
            }
        }
    }

}
