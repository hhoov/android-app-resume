package com.example.android.justjava;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.List;

public class MoviesListActivity extends AppCompatActivity {
    private NavigationDrawerDelegate navDrawerDelegate;
    // Used when data is initialized within this activity
    // where initializeData() is a MovieData class function
    public MovieData movieData = new MovieData("","");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_list);

        // Used when data is initialized within this activity
        // where initializeData() is a MovieData class function
        List<MovieData> movieDataList = movieData.initializeData();
        
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

        // Used when data is initialized within this activity
        // Specify an adapter
        RecyclerView.Adapter mAdapter = new MyAdapter(getApplicationContext(), movieDataList);
        mRecyclerView.setAdapter(mAdapter);

        // Used when data is initialized in Adapter
        // Specify an adapter
        //RecyclerView.Adapter mAdapter = new MyAdapter(getApplicationContext());
        //mRecyclerView.setAdapter(mAdapter);

        // Grid layout manager
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this, noOfColumns);
        mRecyclerView.setLayoutManager(gridLayoutManager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return navDrawerDelegate.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }



}
