package com.example.android.justjava;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.android.justjava.model.MovieSummaryData;

import java.util.List;

import javax.inject.Inject;

public class MoviesGridActivity extends AppCompatActivity implements MoviesPresenter.MoviesView {
    private NavigationDrawerDelegate navDrawerDelegate;
    private MovieAdapter adapter;

    @Inject
    MoviesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MovieApplication.getApplicationComponent().inject(this);
        setContentView(R.layout.activity_movies_grid);

        // Set up navigation drawer and toolbar
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        NavigationView navView = findViewById(R.id.nav_view);
        navDrawerDelegate = new NavigationDrawerDelegate(this, drawerLayout, toolbar, navView);
        navDrawerDelegate.setupNavDrawer();

        // Calculate number of columns to determine spanCount for GridLayoutManager()
        int noOfColumns = getResources().getInteger(R.integer.numberOfColumnsForGridView);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        // Using this setting if changes in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // Specify an adapter
        adapter = new MovieAdapter();
        recyclerView.setAdapter(adapter);

        // Grid layout manager
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this, noOfColumns);
        recyclerView.setLayoutManager(gridLayoutManager);

        presenter.attach(this);
        presenter.present();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return navDrawerDelegate.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    public void setMovies(List<MovieSummaryData> movieSummaryDataList) { adapter.setData(movieSummaryDataList); }

    public void showError() {
        // TODO
        Toast.makeText(getApplicationContext(), "Oops! Failed to retrieve movie provider.", Toast.LENGTH_SHORT).show();
    }
}
