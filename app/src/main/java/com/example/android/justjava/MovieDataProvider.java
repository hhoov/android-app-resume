package com.example.android.justjava;

import java.util.ArrayList;
import java.util.List;

public class MovieDataProvider {
    private static MovieDataProvider singletonInstance;
    private final List<MovieData> movieDataList;

    private MovieDataProvider() {
        movieDataList = new ArrayList<>();
        movieDataList.add(new MovieData("Deadpool", "https://static.comicvine.com/uploads/original/8/83918/4818925-deadpool-one-sheet.jpg"));
        movieDataList.add(new MovieData("Wonder Woman", "https://images-na.ssl-images-amazon.com/images/I/41hBg-ZaiTL.jpg"));
        movieDataList.add(new MovieData("Star Wars: The Last Jedi", "https://images-na.ssl-images-amazon.com/images/I/51poKKV63GL.jpg"));
        movieDataList.add(new MovieData("The Intouchables", "http://img.moviepostershop.com/the-intouchables-movie-poster-2012-1020750880.jpg"));
        movieDataList.add(new MovieData("The Magnificent Seven", "http://farawayentertainment.com/wp-content/uploads/2016/09/Magnificent-Seven-Poster.jpg"));
        movieDataList.add(new MovieData("Coco", "http://www.pcmnoticias.mx/wp-content/uploads/2017/10/coco-poster.jpg"));
        movieDataList.add(new MovieData("Lost in Translation", "https://i.pinimg.com/originals/e5/2a/b0/e52ab028751846fdfc969a1bfa657e2e.jpg"));
        movieDataList.add(new MovieData("Caddyshack", "https://images-na.ssl-images-amazon.com/images/I/51qVp-dXLgL.jpg"));
        movieDataList.add(new MovieData("M*A*S*H", "http://s3cf.recapguide.com/img/posters/MASH_s.jpg"));
        movieDataList.add(new MovieData("Blade Runner", "http://nethd.org/imdb/posters/0083658.jpg"));
        movieDataList.add(new MovieData("The Disaster Artist", "https://images-na.ssl-images-amazon.com/images/I/91HoutFCtjL._RI_.jpg"));
        movieDataList.add(new MovieData("Kong: Skull Island", "http://www.joblo.com/posters/images/full/kong_skull_island_poster_new.jpg"));
        movieDataList.add(new MovieData("The Lord of the Rings", "https://images-na.ssl-images-amazon.com/images/I/51Qvs9i5a%2BL.jpg"));
        movieDataList.add(new MovieData("High Society", "http://img.moviepostershop.com/high-society-movie-poster-1956-1020143906.jpg"));
        movieDataList.add(new MovieData("2001: A Space Odyssey", "http://www.fatmovieguy.com/wp-content/uploads/2014/12/2001-A-Space-Odyssey-Movie-Poster.png"));
        movieDataList.add(new MovieData("Big Fish", "http://static.tumblr.com/isksdmr/C5jndnrbe/0019827photo.jpg"));
        movieDataList.add(new MovieData("Rogue One", "https://i.pinimg.com/originals/a9/a7/56/a9a756aeda6f2f56fe271e278141903f.jpg"));
        movieDataList.add(new MovieData("Harry Potter and the Deathly Hallows Part 2", "https://www.dvdsreleasedates.com/posters/800/H/Harry-Potter-and-the-Deathly-Hallows-Part-2-2011-movie-poster.jpg"));
        movieDataList.add(new MovieData("Jurassic Park", "http://img.moviepostershop.com/jurassic-park-movie-poster-1992-1020141477.jpg"));
        movieDataList.add(new MovieData("Spider-Man: Homecoming", "https://www.sonypictures.com/movies/spidermanhomecoming/assets/images/onesheet.jpg"));
        movieDataList.add(new MovieData("Logan", "https://s3.amazonaws.com/ffe-ugc/intlportal2/dev-temp/en-US/__595033e88ceb2.jpg"));
        movieDataList.add(new MovieData("Deadpool 2", "http://www.myconfinedspace.com/wp-content/uploads/2018/02/Deadpool-Flash-Dance-Movie-Poster.jpg"));
        movieDataList.add(new MovieData("Meru", "http://static1.squarespace.com/static/547f2244e4b09257c91d7bbf/5647a0e9e4b05bec17b9dc75/5647a414e4b05343228fe5d7/1455124141917/?format=1000w"));
        movieDataList.add(new MovieData("Indiana Jones: The Last Crusade", "https://i.pinimg.com/originals/ac/82/84/ac8284e15add404d129c098f01c1e3d9.jpg"));
        movieDataList.add(new MovieData("Frances Ha", "http://www.ondacinema.it/images/locandine/FrancesHa-poster.jpg"));
        movieDataList.add(new MovieData("Inside Out", "http://communications.penrhos.wa.edu.au/pcn/2015-05-08/images/insideout.jpg"));
        movieDataList.add(new MovieData("The Secret Life of Walter Mitty", "http://www.undertheradarmag.com/uploads/article_images/111the-secret-life-of-walter-mitty-poster1-400x600.jpg"));
        movieDataList.add(new MovieData("Toy Story", "https://vignette.wikia.nocookie.net/transcripts/images/2/2a/Disney_and_Pixar%27s_Toy_Story_-_iTunes_Movie_Poster.jpg/revision/latest?cb=20170206021624"));
    }

    public static MovieDataProvider getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new MovieDataProvider();
        }
        return singletonInstance;
    }

    public List<MovieData> getMovieData() {
        return movieDataList;
    }

}
