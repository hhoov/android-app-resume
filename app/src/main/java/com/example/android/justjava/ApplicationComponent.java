package com.example.android.justjava;

import com.example.android.justjava.provider.MovieDataProvider;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(MoviesGridActivity moviesGridActivity);
    void inject(MoviesListActivity moviesListActivity);
    void inject(MovieDetailsActivity movieDetailsActivity);
    void inject(MovieDataProvider movieDataProvider);
}
