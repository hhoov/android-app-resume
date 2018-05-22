package com.example.android.justjava;

import com.example.android.justjava.data.MovieDataProvider;
import com.example.android.justjava.model.MovieData;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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
    public void setsMoviesWhenPresentCalledTest() throws IOException {
        ArrayList<MovieData> movieData = new ArrayList<>();
        movieData.add(new MovieData(12,"title", 2, "imdbid3432", 45, 34, "poster url","imdb link"));

        when(mockMovieDataProvider.getMovieData()).thenReturn(movieData);
        presenter.present();
        verify(mockMoviesView, never()).showError();
        verify(mockMoviesView).setMovies(movieData);
    }

    @Test
    public void showsErrorWhenPresentCalledTest() throws IOException {
        doThrow(new IOException()).when(mockMovieDataProvider).getMovieData();
        presenter.present();
        verify(mockMoviesView, never()).setMovies(anyListOf(MovieData.class));
        verify(mockMoviesView).showError();
    }

}
