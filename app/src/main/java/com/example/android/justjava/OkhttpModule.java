package com.example.android.justjava;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class OkhttpModule {


    public OkhttpModule() {

    }

    @Provides
    @Singleton
    OkHttpClient provideOkhttpClient() {
        OkHttpClient client = new OkHttpClient();
        return client;
    }
}
