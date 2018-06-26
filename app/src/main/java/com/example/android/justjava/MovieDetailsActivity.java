package com.example.android.justjava;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.justjava.model.MovieDetailData;

public class MovieDetailsActivity extends AppCompatActivity {

    private ImageView poster;
    private TextView rating, votes, id, title, year, rated, released, runtime, genre;
    private TextView director, writer, actors, plot, language, country, awards, metascore;

    public MovieDetailsActivity() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        poster = (ImageView) findViewById(R.id.posterImageView);
        title = (TextView) findViewById(R.id.titleTextView);
        id = (TextView) findViewById(R.id.imdbIdTextView);

        Intent intent = getIntent();
        String action = intent.getAction();
        Uri data = intent.getData();

        MovieDetailData movieDetailData = (MovieDetailData) intent.getExtras().getSerializable("movie_details");

        /*Intent results = getIntent();
        //intent.getExtras();

        String id = results.getStringExtra(textView.toString());

        textView.setText(id);*/

    }

/*    @Override
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
    }*/


}