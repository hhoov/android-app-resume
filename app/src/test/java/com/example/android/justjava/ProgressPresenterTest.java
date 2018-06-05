package com.example.android.justjava;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProgressPresenterTest {
    @Mock(name = "Movies View") private ProgressPresenter.ProgressView mockProgressView;
    @Mock(name = "Progress Provider") private ProgressProvider mockProgressProvider;

    @InjectMocks
    private ProgressPresenter presenter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        presenter = new ProgressPresenter(mockProgressProvider);
        //presenter.attach(mockProgressView);
    }

}
