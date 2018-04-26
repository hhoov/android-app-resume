package com.example.android.justjava;

import dagger.Module;
import dagger.Provides;

@Module
public class OkhttpModule {
    private final OkhttpSetUp mOkhttpSetUp;
    private String url;

    public OkhttpModule(OkhttpSetUp ok) {
        mOkhttpSetUp = ok;
    }

    @Provides
    OkhttpSetUp provideOkhttpSetUp() {
        return new OkhttpSetUp();
    }
}
