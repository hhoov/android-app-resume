package com.example.android.justjava;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {OkhttpModule.class})
public interface ApplicationComponent {
    void inject(MoviesGridActivity moviesGridActivity);
    void inject(MoviesListActivity moviesListActivity);

}
