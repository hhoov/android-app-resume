package com.example.android.justjava;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.android.justjava.model.MovieDetailData;

public class MovieDetailsActivity extends AppCompatActivity {

    //@Inject MovieSummaryPresenter movieSummaryPresenter;

    //private ImageView poster;
    //private TextView rating, votes, id, title, year, rated, released, runtime, genre;
    //private TextView director, writer, actors, plot, language, country, awards, metascore;

    public MovieDetailsActivity() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //MyApplication.getApplicationComponent().inject(this);
        setContentView(R.layout.activity_details);

        TextView id = (TextView) findViewById(R.id.imdbIdTextView);
        Log.d("ID b4 getIntent() -- ", id.toString());

        Intent intent = getIntent();
        String action = intent.getAction();
        Uri data = intent.getData();


        Log.d("ID AFTER intent -- ", id.toString());

        MovieDetailData movieDetailData = (MovieDetailData) intent.getParcelableExtra("detailData");

        id.setText(movieDetailData.getImdbId());

        Log.d("After Parcel -- ", id.toString());



        //id.setText(movieDetailData.getImdbId());
        //Log.d(" ID -- ", id.toString());

        //title.setText(movieDetails.getTitle());
        //id.setText(movieDetails.getImdbId());

    }

}