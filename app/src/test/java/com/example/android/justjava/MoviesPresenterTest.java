package com.example.android.justjava;

import com.example.android.justjava.data.MovieDataProvider;
import com.example.android.justjava.model.MovieData;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.anyListOf;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MoviesPresenterTest {

    @Mock(name = "Movies View") private MoviesPresenter.MoviesView mockMoviesView;
    @Mock(name = "Movie Data Provider") private MovieDataProvider mockMovieDataProvider;

    @InjectMocks
    private MoviesPresenter presenter;
    private DirectExecutor executor;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        executor = new DirectExecutor();
        presenter = new MoviesPresenter(mockMovieDataProvider, executor, executor);
        presenter.attach(mockMoviesView);
    }

    @Test
    public void shouldGetMovies() throws IOException {
        ArrayList<MovieData> movieData = new ArrayList<>();
        movieData.add(new MovieData(12,"eh", 2, "89", 45, 34, "fes",""));

        when(mockMovieDataProvider.getMovieData()).thenReturn(movieData);
        presenter.present();
        verify(mockMoviesView, never()).showError();
        verify(mockMoviesView).setMovies(movieData);
    }

    @Test(expected = MockitoException.class)
    public void shouldShowErrorTest() {
        doThrow(new IOException()).when(mockMoviesView).setMovies(new ArrayList<MovieData>());
        verify(mockMoviesView, never()).setMovies(anyListOf(MovieData.class));
        verify(mockMoviesView).showError();

    }

}
