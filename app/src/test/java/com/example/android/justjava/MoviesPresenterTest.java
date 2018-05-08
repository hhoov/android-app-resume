package com.example.android.justjava;

import com.example.android.justjava.model.MovieData;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;

public class MoviesPresenterTest {

    @Mock
    private MoviesPresenter presenter;
    private OkhttpHelper ok;
    @Mock private MoviesPresenter.MoviesView mockView = null;
    private ArrayList<MovieData> mockMoviesList;
    private String mockJson;

    @Ignore
    @Before
    public void setup() throws Exception {
        mockView = mock(MoviesPresenter.MoviesView.class);
        //mockMoviesList = mock(MovieDataProvider.getInstance(mockJson).getMovieData());
    }

    @Test
    public void shouldAttachTest() {
        MoviesPresenter presenter = new MoviesPresenter(ok);
        assertNull(mockView);

        presenter.attach(mockView);
        assertNotNull(mockView);
    }

    @Test
    public void shouldDetachTest() {
        MoviesPresenter presenter = new MoviesPresenter(ok);
        assertNotNull(mockView);

        presenter.detach();
        assertNull(mockView);

    }

    @Ignore
    @Test
    public void shouldSetMoviesTest() {
        List<MovieData> expectedMoviesListSize = new ArrayList<>(100);
        List<MovieData> testOutput = null;
        presenter.view.setMovies(mockMoviesList);
        assertFalse(testOutput.isEmpty());
        assertEquals(expectedMoviesListSize, testOutput);
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
