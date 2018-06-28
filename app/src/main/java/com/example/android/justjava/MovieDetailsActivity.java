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

    //private ImageView poster;
    //private TextView rating, votes, id, title, year, rated, released, runtime, genre;
    //private TextView director, writer, actors, plot, language, country, awards, metascore;

    public MovieDetailsActivity() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        String action = intent.getAction();
        Uri data = intent.getData();

        TextView id = (TextView) findViewById(R.id.imdbIdTextView);

        MovieDetailData movieDetailData = (MovieDetailData) getIntent().getExtras().getSerializable("ID");

        id.setText(movieDetailData.getImdbId());
        Log.d(" ID -- ", id.toString());

        //title.setText(movieDetails.getTitle());
        //id.setText(movieDetails.getImdbId());

    }

}