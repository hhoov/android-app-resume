package com.example.android.justjava;

import dagger.Component;

@Component(modules = {OkhttpModule.class})
public interface OkhttpComponent {
    //OkhttpSetUp provideOkhttpSetUp(String url);
    void inject(MoviesGridActivity moviesGridActivity);
    void inject(MoviesListActivity moviesListActivity);

}
