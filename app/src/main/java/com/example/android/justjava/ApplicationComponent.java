package com.example.android.justjava;

import com.example.android.justjava.data.MovieDataProvider;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(MoviesGridActivity moviesGridActivity);
    void inject(MoviesListActivity moviesListActivity);
    void inject(MovieDataProvider movieDataProvider);
}
