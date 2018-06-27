package com.example.android.justjava;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

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

        //MovieDetailData movieDetails = (MovieDetailData) getIntent().getExtras().getSerializable("imdbId");

        //poster = (ImageView) findViewById(R.id.posterImageView);
        //TextView title = (TextView) findViewById(R.id.titleTextView);
        TextView id = (TextView) findViewById(R.id.imdbIdTextView);

        Intent intent = getIntent();
        String action = intent.getAction();
        Uri data = intent.getData();

        //title.setText(movieDetails.getTitle());
        //id.setText(movieDetails.getImdbId());

    }

}