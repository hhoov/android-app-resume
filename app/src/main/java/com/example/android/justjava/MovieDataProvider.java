package com.example.android.justjava;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MovieDataProvider {
    private static MovieDataProvider singletonInstance;
    private JSONParser parser = new JSONParser();

    // Private constructor prevents any other class from instantiating.
    private MovieDataProvider() {
    }

    // Static instance method
    public static MovieDataProvider getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new MovieDataProvider();
        }
        return singletonInstance;
    }

    // Start thread that populates list
    public List<MovieData> getMovieData() throws IOException {
        String json = "[{\"rank\":1,\"title\":\"The Godfather\",\"year\":1972,\"imdbId\":\"tt0068646\",\"imdbRating\":9.2,\"imdbVotes\":1106047,\"poster\":\"http://ia.media-imdb.com/images/M/MV5BMjEyMjcyNDI4MF5BMl5BanBnXkFtZTcwMDA5Mzg3OA@@._V1_SX300.jpg\",\"imdbLink\":\"http://www.imdb.com/title/tt0068646/\"},{\"rank\":2,\"title\":\"The Shawshank Redemption\",\"year\":1994,\"imdbId\":\"tt0111161\",\"imdbRating\":9.3,\"imdbVotes\":1615020,\"poster\":\"http://ia.media-imdb.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1_SX300.jpg\",\"imdbLink\":\"http://www.imdb.com/title/tt0111161/\"}]";
        return parser.readJsonStream(json);
    }

}
