package com.example.android.justjava;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

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
        Log.d("INTENT -- ", intent.toString());
        String action = intent.getAction();
        if (action != null) {
            Log.d("ACTION -- ", action);
        }
        Uri data = intent.getData();
        if (data != null) {
            Log.d("URI -- ", data.toString());
        }

        Log.d("ID AFTER intent -- ", id.toString());

        //MovieDetailData movieDetailData = (MovieDetailData) getIntent().getExtras().getSerializable("ID");

        //id.setText(movieDetailData.getImdbId());
        //Log.d(" ID -- ", id.toString());

        //title.setText(movieDetails.getTitle());
        //id.setText(movieDetails.getImdbId());

    }

}