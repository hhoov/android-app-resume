package com.example.android.justjava;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.MenuItem;

public class MoviesGridActivity extends AppCompatActivity {
    private NavigationDrawerDelegate navDrawerDelegate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_grid);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        NavigationView navView = findViewById(R.id.nav_view);
        navDrawerDelegate = new NavigationDrawerDelegate(this, drawerLayout, toolbar, navView);
        navDrawerDelegate.setupNavDrawer();

        // Retrieve string array
        Resources res;
        res = getResources();
        String[] myDataset = res.getStringArray(R.array.list_movies);

        // Calculate number of columns to determine spanCount for GridLayoutManager()
        int noOfColumns = calculateNoOfColumns(getApplicationContext());

        RecyclerView mRecyclerView = findViewById(R.id.my_recycler_view);

        // Using this setting if changes in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // Specify an adapter
        RecyclerView.Adapter mAdapter = new MyAdapter(getApplicationContext(), myDataset);
        mRecyclerView.setAdapter(mAdapter);

        // Grid layout manager
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this, noOfColumns);
        mRecyclerView.setLayoutManager(gridLayoutManager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return navDrawerDelegate.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    public int calculateNoOfColumns(Context context) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
            return (int) (dpWidth / 180);
        }
}
