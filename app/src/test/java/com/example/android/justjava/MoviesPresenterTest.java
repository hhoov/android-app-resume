package com.example.android.justjava;

import com.example.android.justjava.model.MovieData;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

public class MoviesPresenterTest {

    MoviesPresenter presenter;
    private OkhttpHelper ok;

    @Test
    public void shouldAttachTest() {
        MoviesPresenter presenter = new MoviesPresenter(ok);
        assertNull(presenter.view);

        presenter.attach(presenter.view);
        assertNotNull(presenter.view);
    }

    @Test
    public void shouldDetachTest() {
        MoviesPresenter presenter = new MoviesPresenter(ok);
        assertNotNull(presenter.view);

        presenter.detach();
        assertNull(presenter.view);

    }

    @Test
    public void shouldSetMoviesTest() {

        List<MovieData> expectedMoviesListSize = new ArrayList<>(100);
        List<MovieData> testOutput = null;
        presenter.view.setMovies(testOutput);
        assertFalse(testOutput.isEmpty());
        assertEquals(expectedMoviesListSize, testOutput);
    }

    @Test
    public void shouldSetMoviesInThreadTest() {

    }

    @Test
    public void shouldShowErrorTest() {

    }

}
