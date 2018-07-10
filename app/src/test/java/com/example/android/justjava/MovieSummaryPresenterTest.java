package com.example.android.justjava;

import com.example.android.justjava.provider.ProgressProvider;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MovieSummaryPresenterTest {
    @Mock(name = "Movies View") private MovieSummaryPresenter.MovieSummaryView mockMovieSummaryView;
    @Mock(name = "Progress Provider") private ProgressProvider mockProgressProvider;

    @InjectMocks
    private MovieSummaryPresenter presenter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        //presenter = new MovieSummaryPresenter(mockProgressProvider);
        //presenter.attach(mockMovieSummaryView);
    }

}
