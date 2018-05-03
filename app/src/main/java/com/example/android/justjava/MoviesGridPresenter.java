package com.example.android.justjava;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.android.justjava.data.MovieDataProvider;
import com.example.android.justjava.model.MovieData;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

/** Presenter and View with help from https://github.com/techyourchance/android_mvc_tutorial
 * MVP presenter.
 * Listens to user input from UI, through View, retrieves the data and tells View to update
 * the UI as required.
 */
public class MoviesGridPresenter implements ResultsInterface {
    private MyAdapter adapter;
    private String url = "https://raw.githubusercontent.com/MercuryIntermedia/Sample_Json_Movies/master/top_movies.json";
    private String jsonData;

    //todo

    @Inject OkhttpSetUp ok;

    @Inject
    MoviesGridPresenter() {

    }

    private final Handler handler = new Handler();
    public void handleDataThread() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    jsonData = ok.okhttpHelper(url);
                    final List<MovieData> movieData = MovieDataProvider.getInstance(jsonData).getMovieData();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            onResults(movieData);
                        }
                    });
                } catch (IOException e) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            onError();
                        }
                    });
                }
            }
        });
        thread.start();
    }

    @Override
    public void onResults(List<MovieData> movieDataList) { adapter.setData(movieDataList);}

    @Override
    public void onError() {
        // todo
    }

    interface  MoviesGridView {
        // todo

        /**
         * Get the root Android View which is used internally by this MVP View for presenting data
         * to the user.
         * @return root Android View of this MVP View
         */
        View getRootView();

        /**
         * This method aggregates all the information about the state of this MVP View into Bundle
         * object. The keys in the returned Bundle must be provided as public constants inside the
         * interfaces (or implementations if no interface defined) of concrete MVP views.
         * @return Bundle containing the state of this MVC View, or null if the view has no state
         */
        Bundle getViewStat();
    }




}
