package com.example.android.justjava;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MoviesListActivity extends AppCompatActivity {
    private NavigationDrawerDelegate navDrawerDelegate;
    List<MovieData> movieData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_list);

        movieData = initializeData();
        
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        NavigationView navView = findViewById(R.id.nav_view);
        navDrawerDelegate = new NavigationDrawerDelegate(this, drawerLayout, toolbar, navView);
        navDrawerDelegate.setupNavDrawer();

        // Calculate number of columns to determine spanCount for GridLayoutManager()
        int noOfColumns = getResources().getInteger(R.integer.numberOfColumnsForGridView);

        RecyclerView mRecyclerView = findViewById(R.id.my_recycler_view);

        // Using this setting if changes in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // Specify an adapter
        RecyclerView.Adapter mAdapter = new MyAdapter(movieData);
        mRecyclerView.setAdapter(mAdapter);

        // Grid layout manager
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this, noOfColumns);
        mRecyclerView.setLayoutManager(gridLayoutManager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return navDrawerDelegate.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    public List<MovieData> initializeData() {
        movieData = new ArrayList<>();
        movieData.add(new MovieData("Deadpool", "https://static.comicvine.com/uploads/original/8/83918/4818925-deadpool-one-sheet.jpg"));
        movieData.add(new MovieData("Wonder Woman", "https://images-na.ssl-images-amazon.com/images/I/41hBg-ZaiTL.jpg"));
        movieData.add(new MovieData("Star Wars: The Last Jedi", "https://images-na.ssl-images-amazon.com/images/I/51poKKV63GL.jpg"));
        movieData.add(new MovieData("The Intouchables", "http://img.moviepostershop.com/the-intouchables-movie-poster-2012-1020750880.jpg"));
        movieData.add(new MovieData("The Magnificent Seven", "http://farawayentertainment.com/wp-content/uploads/2016/09/Magnificent-Seven-Poster.jpg"));
        movieData.add(new MovieData("Coco", "http://www.pcmnoticias.mx/wp-content/uploads/2017/10/coco-poster.jpg"));
        movieData.add(new MovieData("Lost in Translation", "https://i.pinimg.com/originals/e5/2a/b0/e52ab028751846fdfc969a1bfa657e2e.jpg"));
        movieData.add(new MovieData("Caddyshack", "https://images-na.ssl-images-amazon.com/images/I/51qVp-dXLgL.jpg"));
        movieData.add(new MovieData("M*A*S*H", "http://s3cf.recapguide.com/img/posters/MASH_s.jpg"));
        movieData.add(new MovieData("Blade Runner", "http://nethd.org/imdb/posters/0083658.jpg"));
        movieData.add(new MovieData("The Disaster Artist", "https://images-na.ssl-images-amazon.com/images/I/91HoutFCtjL._RI_.jpg"));
        movieData.add(new MovieData("Kong: Skull Island", "http://www.joblo.com/posters/images/full/kong_skull_island_poster_new.jpg"));
        movieData.add(new MovieData("The Lord of the Rings", "https://images-na.ssl-images-amazon.com/images/I/51Qvs9i5a%2BL.jpg"));
        movieData.add(new MovieData("High Society", "http://img.moviepostershop.com/high-society-movie-poster-1956-1020143906.jpg"));
        movieData.add(new MovieData("2001: A Space Odyssey", "http://www.fatmovieguy.com/wp-content/uploads/2014/12/2001-A-Space-Odyssey-Movie-Poster.png"));
        movieData.add(new MovieData("Big Fish", "http://static.tumblr.com/isksdmr/C5jndnrbe/0019827photo.jpg"));
        movieData.add(new MovieData("Rogue One", "https://i.pinimg.com/originals/a9/a7/56/a9a756aeda6f2f56fe271e278141903f.jpg"));
        movieData.add(new MovieData("Harry Potter and the Deathly Hallows Part 2", "https://www.dvdsreleasedates.com/posters/800/H/Harry-Potter-and-the-Deathly-Hallows-Part-2-2011-movie-poster.jpg"));
        movieData.add(new MovieData("Jurassic Park", "http://img.moviepostershop.com/jurassic-park-movie-poster-1992-1020141477.jpg"));
        movieData.add(new MovieData("Spider-Man: Homecoming", "https://www.sonypictures.com/movies/spidermanhomecoming/assets/images/onesheet.jpg"));
        movieData.add(new MovieData("Logan", "https://s3.amazonaws.com/ffe-ugc/intlportal2/dev-temp/en-US/__595033e88ceb2.jpg"));
        movieData.add(new MovieData("Deadpool 2", "http://www.myconfinedspace.com/wp-content/uploads/2018/02/Deadpool-Flash-Dance-Movie-Poster.jpg"));
        movieData.add(new MovieData("Meru", "http://static1.squarespace.com/static/547f2244e4b09257c91d7bbf/5647a0e9e4b05bec17b9dc75/5647a414e4b05343228fe5d7/1455124141917/?format=1000w"));
        movieData.add(new MovieData("Indiana Jones: The Last Crusade", "https://i.pinimg.com/originals/ac/82/84/ac8284e15add404d129c098f01c1e3d9.jpg"));
        movieData.add(new MovieData("Frances Ha", "http://www.ondacinema.it/images/locandine/FrancesHa-poster.jpg"));
        movieData.add(new MovieData("Inside Out", "http://communications.penrhos.wa.edu.au/pcn/2015-05-08/images/insideout.jpg"));
        movieData.add(new MovieData("The Secret Life of Walter Mitty", "http://www.undertheradarmag.com/uploads/article_images/111the-secret-life-of-walter-mitty-poster1-400x600.jpg"));
        movieData.add(new MovieData("Toy Story", "https://vignette.wikia.nocookie.net/transcripts/images/2/2a/Disney_and_Pixar%27s_Toy_Story_-_iTunes_Movie_Poster.jpg/revision/latest?cb=20170206021624"));
        return movieData;
    }

}
