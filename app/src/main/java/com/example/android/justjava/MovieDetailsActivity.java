package com.example.android.justjava;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.android.justjava.model.MovieDetailData;

import java.util.List;

import javax.inject.Inject;

public class MovieDetailsActivity extends AppCompatActivity implements MovieDetailsPresenter.MovieDetailsView{

    @Inject
    MovieDetailsPresenter presenter;

    public MovieDetailsActivity() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getApplicationComponent().inject(this);
        setContentView(R.layout.activity_details);

        //getActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String action = intent.getAction();
        Uri data = intent.getData();

        //Toolbar toolbar = findViewById(R.id.toolbar);

        presenter.attach(this);
        presenter.present();

    }

    @Override
    public void setMovieDetails(List<MovieDetailData> movieDetailDataList) {

    }

    @Override
    public void showError() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.nav_movies_grid:
                //finish();
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.id.nav_movies_list:
                //finish();
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}