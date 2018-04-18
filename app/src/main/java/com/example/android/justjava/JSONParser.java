package com.example.android.justjava;

import android.content.res.Resources;
import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JSONParser {

    private int rank = 0;
    private int year = 0;
    private double imdbRating = 0;
    private int imdbVotes = 0;
    private String title = null;
    private String imdbId = null;
    private String poster = null;
    private String imdbLink = null;

    public List<MovieData> readJsonStream(Resources resources, int id) throws IOException {
        InputStream resourceReader = resources.openRawResource(id);
        JsonReader reader = new JsonReader(new InputStreamReader(resourceReader, "UTF-8"));
        try {
            return readMoviesArray(reader);
        } finally {
            reader.close();
        }
    }

    private List<MovieData> readMoviesArray(JsonReader reader) throws IOException {
        List<MovieData> movies = new ArrayList<>();

        reader.beginArray();
        while (reader.hasNext()) {
            movies.add(readMovie(reader));
        }
        reader.endArray();
        return movies;
    }

    private MovieData readMovie(JsonReader reader) throws IOException {
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            switch (name) {
                case "rank":
                    rank = reader.nextInt();
                    break;
                case "title":
                    title = reader.nextString();
                    break;
                case "year":
                    year = reader.nextInt();
                    break;
                case "imdbId":
                    imdbId = reader.nextString();
                    break;
                case "imdbRating":
                    imdbRating = reader.nextDouble();
                    break;
                case "imdbVotes":
                    imdbVotes = reader.nextInt();
                    break;
                case "poster":
                    poster = reader.nextString();
                    break;
                case "imdbLink":
                    imdbLink = reader.nextString();
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();
        return new MovieData(rank, title, year, imdbId, imdbRating, imdbVotes, poster, imdbLink);
    }

}
