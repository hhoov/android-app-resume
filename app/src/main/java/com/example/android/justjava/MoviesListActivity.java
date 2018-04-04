package com.example.android.justjava;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MenuItem;

public class MoviesListActivity extends AppCompatActivity {
    private NavigationDrawerDelegate navDrawerDelegate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_list);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        NavigationView navView = findViewById(R.id.nav_view);
        navDrawerDelegate = new NavigationDrawerDelegate(this, drawerLayout, toolbar, navView);
        navDrawerDelegate.setupNavDrawer();

        // Retrieve string array
        Resources res;
        res = getResources();
        String[] myDataset = res.getStringArray(R.array.list_movies);

        float deviceWidth = getScreenWidth();
        System.out.println("\n****** DEVICE WIDTH *******: " + deviceWidth + "\n");
        //Context mContext = getApplicationContext();

        if (deviceWidth >= 600) {
            // Change content views
            setContentView(R.layout.activity_movies_grid);

            drawerLayout = findViewById(R.id.drawer_layout);
            toolbar = findViewById(R.id.toolbar);
            navView = findViewById(R.id.nav_view);
            navDrawerDelegate = new NavigationDrawerDelegate(this, drawerLayout, toolbar, navView);
            navDrawerDelegate.setupNavDrawer();

/*            GridView gridView = findViewById(R.id.gridView);
            GridAdapter gridAdapter = new GridAdapter(this, myDataset);
            gridView.setAdapter(gridAdapter);*/

            RecyclerView mRecyclerView = findViewById(R.id.my_recycler_view);
            //mRecyclerView.setHasFixedSize(true);
            RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this, (int) deviceWidth);
            mRecyclerView.setLayoutManager(gridLayoutManager);

            // Specify an adapter
            RecyclerView.Adapter gridAdapter = new GridAdapter(this, myDataset);
            mRecyclerView.setAdapter(gridAdapter);


        } else {
            RecyclerView mRecyclerView = findViewById(R.id.my_recycler_view);

            // Using this setting if changes in content do not change the layout size of the RecyclerView
            mRecyclerView.setHasFixedSize(true);

            // Linear layout manager
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
            mRecyclerView.setLayoutManager(mLayoutManager);

            // Specify an adapter
            RecyclerView.Adapter mAdapter = new MyAdapter(this, myDataset);
            mRecyclerView.setAdapter(mAdapter);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return navDrawerDelegate.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    public float getScreenWidth() {
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float density = getResources().getDisplayMetrics().density;
        return outMetrics.widthPixels / density;
    }
}
