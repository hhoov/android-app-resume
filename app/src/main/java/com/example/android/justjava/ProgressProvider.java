package com.example.android.justjava;

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

    ProgressProvider(final String movieID) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (downloadProgress < 30 && movieID.equals(FIXED_MOVIE_ID)) {
                    while (downloadProgress < 30 && observerMap.containsKey(movieID)) {

                        downloadProgress++;
                        notifyObservers(downloadProgress);

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

                // TODO: need to handle when observed movie reaches complete download
                // TODO: need to handle checking if movieID is currently observed, whether to ++ or set = 0
                else if (downloadProgress == 30 && movieID.equals(FIXED_MOVIE_ID)) {
                    System.out.println("Progress completed for fixed movie download.");
                }

                else downloadProgress = 0;

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
        if (observerMap.isEmpty()) {
            observerMap.put(movieID, new HashSet<ProgressPresenter>());
        }
        else if (!observerMap.containsKey(movieID)) {
            observerMap.put(movieID, new HashSet<ProgressPresenter>());
        }

        /*
          TODO -- Since hashset *allows* duplicates, need to check that presenter isn't already added?
              or have check on onProgressUpdated? or does it even matter bc it will still show the
              same updated progress for that presenter
        */
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
