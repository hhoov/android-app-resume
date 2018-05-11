package com.example.android.justjava;

import com.example.android.justjava.data.MovieDataProvider;
import com.example.android.justjava.model.MovieData;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowToast;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(RobolectricTestRunner.class) // Supposed to help with testing for appearance of a Toast
@Config(constants = BuildConfig.class) // Part of testing for Toasts as well
public class MoviesPresenterTest {

    @Mock(name = "Movies View") private MoviesPresenter.MoviesView moviesView;

    // Could I use @Inject here for okhttp?
    private OkHttpClient okClient = new OkHttpClient();
    private OkhttpHelper ok = new OkhttpHelper(okClient);
    private MoviesPresenter presenter = new MoviesPresenter(ok);

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldAttachTest() {
        assertNull(presenter.view);

        presenter.attach(moviesView);
        assertNotNull(presenter.view);
    }

    @Test
    public void shouldDetachTest() {
        presenter.attach(moviesView);
        assertNotNull(presenter.view);

        presenter.detach();
        assertNull(presenter.view);

    }

    @Test
    public void shouldSetMoviesTest() {
        // I'd like to understand more how Mockito can help with this hardcoded data here...
        // Should also find a way to test Okhttp perhaps.
        String url = "https://raw.githubusercontent.com/MercuryIntermedia/Sample_Json_Movies/master/top_movies.json";
        String jsonData = ok.createRequest(url);

        int expectedMoviesListSize = 100;
        List<MovieData> testOutput = null;

        try {
            testOutput = MovieDataProvider.getInstance(jsonData).getMovieData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertFalse(testOutput.isEmpty());
        presenter.attach(moviesView);
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
        // Wait until condition satisfied before continuing...?
    }

    @Ignore
    @Test
    public void shouldShowErrorTest() {
        // TODO
        // Not sure how to test this, as the Exception in present() is already handled within the scope (?)
        // I thought of adding a Toast to fail gracefully/let the user know what happened. I'm still
        //      researching how to test that a Toast is shown but wanted to get feedback before spending too
        //      much time on that if not needed.
        presenter.attach(moviesView);
        presenter.view.showError();
        assertTrue(ShadowToast.getTextOfLatestToast().equals("Oops! Failed to retrieve movie data."));
        assertTrue(ShadowToast.showedToast("Oops! Failed to retrieve movie data."));
    }

}
