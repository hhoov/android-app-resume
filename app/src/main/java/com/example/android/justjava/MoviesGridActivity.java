package com.example.android.justjava;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.justjava.model.MovieData;

import java.util.List;

import javax.inject.Inject;

public class MoviesGridActivity extends AppCompatActivity implements MoviesPresenter.MoviesView, View.OnClickListener {
    private NavigationDrawerDelegate navDrawerDelegate;
    private MyAdapter adapter;

    @Inject
    MoviesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getApplicationComponent().inject(this);
        setContentView(R.layout.activity_movies_grid);

        // Set up navigation drawer and toolbar
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        NavigationView navView = findViewById(R.id.nav_view);
        navDrawerDelegate = new NavigationDrawerDelegate(this, drawerLayout, toolbar, navView);
        navDrawerDelegate.setupNavDrawer();

        // Calculate number of columns to determine spanCount for GridLayoutManager()
        int noOfColumns = getResources().getInteger(R.integer.numberOfColumnsForGridView);

        final RecyclerView mRecyclerView = findViewById(R.id.my_recycler_view);

        // Using this setting if changes in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // Specify an adapter
        adapter = new MyAdapter();
        mRecyclerView.setAdapter(adapter);

        // Grid layout manager
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this, noOfColumns);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        //int position = mRecyclerView.getChildLayoutPosition(this);

        presenter.attach(this);
        presenter.present();

        mRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int itemPosition = mRecyclerView.getChildLayoutPosition(v);
                String item = String.valueOf(itemPosition);
                Log.d("RESULT -- ", item);
            }
        });

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

    public void setMovies(List<MovieData> movieDataList) {
        adapter.setData(movieDataList);
    }

    public void showError() {
        // TODO
        Toast.makeText(getApplicationContext(), "Oops! Failed to retrieve movie provider.", Toast.LENGTH_SHORT).show();
    }

/*    @Override
    public void onItemClick(View v, int itemPosition) {
        itemPosition = mRecyclerView.getChildLayoutPosition(v);
        String item = String.valueOf(itemPosition);
        Log.d("RESULT -- ", item);
        Intent intent = new Intent(this, MovieDetailsActivity.class);
        intent.putExtra("movieDetails", (MovieDetailData)parent.getItemAtPosition(itemPosition));
    }*/

    @Override
    public void onClick(View v) {
        //int index = (int) v.getTag();
        Intent intent = new Intent(v.getContext(), MovieDetailsActivity.class);
        TextView textView = findViewById(R.id.imdbIdTextView);
        intent.putExtra(Intent.EXTRA_TEXT, textView.toString());
        Log.d("BEFORE -- ", "Before put Extra, textview is: " + textView.toString());
        intent.putExtra("imdbID", textView.toString());
        Log.d("AFTER -- " , "After put Extra, textview is: " + textView.toString());
        v.getContext().startActivity(intent);
    }
}
