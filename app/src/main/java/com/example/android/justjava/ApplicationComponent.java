package com.example.android.justjava;

import com.example.android.justjava.provider.MovieDetailProvider;
import com.example.android.justjava.provider.MovieSummaryProvider;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(MoviesGridActivity moviesGridActivity);
    void inject(MoviesListActivity moviesListActivity);
    void inject(MovieDetailActivity movieDetailActivity);
    void inject(MovieSummaryProvider movieSummaryProvider);
    void inject(MovieDetailProvider movieDetailProvider);
}
