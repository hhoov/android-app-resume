package com.example.android.justjava;

import com.example.android.justjava.data.MovieDataProvider;
import com.example.android.justjava.model.MovieData;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;

public class MoviesPresenterTest {

    private OkHttpClient okClient = new OkHttpClient();
    private OkhttpHelper ok;

    @Ignore
    @Before
    public void setup() {
        //mockView = mock(MoviesPresenter.MoviesView.class);
        //mockMoviesList = mock(MovieDataProvider.getInstance(mockJson).getMovieData());
    }

    @Test
    public void shouldAttachTest() {
        MoviesPresenter presenter = new MoviesPresenter(ok);
        assertNull(presenter.view);

        presenter.attach(mock(MoviesPresenter.MoviesView.class));
        assertNotNull(presenter.view);
    }

    @Test
    public void shouldDetachTest() {
        MoviesPresenter presenter = new MoviesPresenter(ok);
        presenter.attach(mock(MoviesPresenter.MoviesView.class));
        assertNotNull(presenter.view);

        presenter.detach();
        assertNull(presenter.view);

    }

    @Test
    public void shouldSetMoviesTest() {
        ok = new OkhttpHelper(okClient);
        String url = "https://raw.githubusercontent.com/MercuryIntermedia/Sample_Json_Movies/master/top_movies.json";
        String jsonData = ok.createRequest(url);
        MoviesPresenter presenter = new MoviesPresenter(ok);

        int expectedMoviesListSize = 100;
        List<MovieData> testOutput = null;

        try {
            testOutput = MovieDataProvider.getInstance(jsonData).getMovieData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertFalse(testOutput.isEmpty());
        presenter.attach(mock(MoviesPresenter.MoviesView.class));
        presenter.view.setMovies(testOutput);
        assertEquals(expectedMoviesListSize, testOutput.size());
    }
    @Ignore
    @Test
    public void shouldSetMoviesInThreadTest() {
        // TODO
        // To test this...maybe:
        // Have two threads, main and worker
        // Make main wait while worker sets movies in background (?)
    }
    @Ignore
    @Test
    public void shouldShowErrorTest() {
        // TODO
    }

}
