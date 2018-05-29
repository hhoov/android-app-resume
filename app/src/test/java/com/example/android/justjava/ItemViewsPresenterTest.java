package com.example.android.justjava;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ItemViewsPresenterTest {
    @Mock(name = "Movies View") private ItemViewsPresenter.ProgressView mockProgressView;
    @Mock(name = "Progress Provider") private ProgressProvider mockProgressProvider;

    @InjectMocks
    private ItemViewsPresenter presenter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        presenter = new ItemViewsPresenter(mockProgressProvider);
        //presenter.attach(mockProgressView);
    }

}
