package com.example.android.justjava;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.io.IOException;
import java.util.List;

public class MoviesListActivity extends AppCompatActivity implements ResultsInterface {
    private NavigationDrawerDelegate navDrawerDelegate;
    private MyAdapter adapter;
    String url = "https://raw.githubusercontent.com/MercuryIntermedia/Sample_Json_Movies/master/top_movies.json";
    String jsonData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_list);

        // Set up navigation drawer and toolbar
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        NavigationView navView = findViewById(R.id.nav_view);
        navDrawerDelegate = new NavigationDrawerDelegate(this, drawerLayout, toolbar, navView);
        navDrawerDelegate.setupNavDrawer();

        // Calculate number of columns to determine spanCount for GridLayoutManager()
        int noOfColumns = getResources().getInteger(R.integer.numberOfColumnsForGridView);

        RecyclerView mRecyclerView = findViewById(R.id.my_recycler_view);

        // Using this setting if changes in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // Specify an adapter
        adapter = new MyAdapter();
        mRecyclerView.setAdapter(adapter);

        final Handler handler = new Handler();
        final OkhttpSetUp ok = new OkhttpSetUp();

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

        // Grid layout manager
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this, noOfColumns);
        mRecyclerView.setLayoutManager(gridLayoutManager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return navDrawerDelegate.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @Override
    public void onResults(List<MovieData> movieList) {
        adapter.setData(movieList);
    }

    @Override
    public void onError() {
        // todo
    }

}
