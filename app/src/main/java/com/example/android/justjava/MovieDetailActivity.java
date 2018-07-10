package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.justjava.model.MovieDetailData;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class MovieDetailActivity extends AppCompatActivity implements MovieDetailPresenter.MovieDetailView {

    @Inject
    MovieDetailPresenter movieDetailPresenter;

    private ImageView poster;
    private TextView rating, votes, id, title, year, rated, released, runtime, genre;
    private TextView director, writer, actors, plot, language, country, awards, metascore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MovieApplication.getApplicationComponent().inject(this);
        setContentView(R.layout.activity_movie_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        this.setSupportActionBar(toolbar);

        ActionBar actionbar = this.getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        //actionbar.setDisplayShowHomeEnabled(true);
        //actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        poster = findViewById(R.id.posterImageView);
        rating = findViewById(R.id.imdbRatingTextView);
        votes = findViewById(R.id.imdbVotesTextView);
        id = findViewById(R.id.imdbIdTextView);
        title = findViewById(R.id.titleTextView);
        year = findViewById(R.id.yearTextView);
        rated = findViewById(R.id.ratedTextView);
        released = findViewById(R.id.releasedTextView);
        runtime = findViewById(R.id.runtimeTextView);
        genre = findViewById(R.id.genreTextView);
        director = findViewById(R.id.directorTextView);
        writer = findViewById(R.id.writerTextView);
        actors = findViewById(R.id.actorsTextView);
        plot = findViewById(R.id.plotTextView);
        language = findViewById(R.id.languageTextView);
        country = findViewById(R.id.countryTextView);
        awards = findViewById(R.id.awardsTextView);
        metascore = findViewById(R.id.metascoreTextView);

        Intent intent = getIntent();
        String action = intent.getAction();
        Uri data = intent.getData();

        String imdbId = intent.getStringExtra("imdbId");

        movieDetailPresenter.attach(this);
        movieDetailPresenter.present(imdbId);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        movieDetailPresenter.detach();
    }

    @Override
    public void showError() {
        // TODO
        Toast.makeText(getApplicationContext(), "Oops! Failed to display movie details.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayMovieDetails(MovieDetailData movieDetailData) {

        rating.setText(String.format("Rating: %s", String.valueOf(movieDetailData.getImdbRating())));
        votes.setText(String.format("Votes: %s", String.valueOf(movieDetailData.getImdbVotes())));
        id.setText(String.format("IMDB ID: %s", movieDetailData.getImdbId()));
        title.setText(String.format("Title: %s", movieDetailData.getTitle()));
        year.setText(String.format("Year: %s", String.valueOf(movieDetailData.getYear())));
        rated.setText(String.format("Rated: %s", movieDetailData.getRated()));
        released.setText(String.format("Released: %s", movieDetailData.getReleased()));
        runtime.setText(String.format("Runtime: %s", movieDetailData.getRuntime()));
        genre.setText(String.format("Genre(s): %s", movieDetailData.getGenre().toString()
                                                .replace("[", "")
                                                .replace("]", "")));
        director.setText(String.format("Director: %s", movieDetailData.getDirector()));
        writer.setText(String.format("Writer(s): %s", movieDetailData.getWriter()));
        actors.setText(String.format("Actors: %s", movieDetailData.getActors().toString()
                                                  .replace("[", "")
                                                  .replace("]", "")));
        plot.setText(String.format("Plot: %s", movieDetailData.getPlot()));
        language.setText(String.format("Language(s): %s", movieDetailData.getLanguage().toString()
                                                      .replace("[", "")
                                                      .replace("]", "")));
        country.setText(String.format("Country: %s", movieDetailData.getCountry()));
        awards.setText(String.format("Award(s): %s", movieDetailData.getAwards()));
        metascore.setText(String.format("Metascore: %s", movieDetailData.getMetascore()));
        // If URL is empty, provide error image
        if (movieDetailData.getPoster().isEmpty()) {
            Picasso.get()
                    .load(R.drawable.error)
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.error)
                    .into(poster);
        } else {
            Picasso
                    .get()
                    .load(movieDetailData.getPoster())
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.error)
                    .resize(500,0)
                    .centerCrop()
                    .into(poster);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return  true;
        }
        return super.onOptionsItemSelected(item);

    }

}