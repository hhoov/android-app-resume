package com.example.android.justjava;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class ApplicationModule {

    ApplicationModule() { }

    @Provides
    @Singleton
    OkHttpClient provideOkhttpClient() {
        return new OkHttpClient();
    }

    @Provides
    @Singleton
    UIExecutor provideUIExecutor() { return new UIExecutor(new Handler(Looper.getMainLooper()));}

    @Provides
    @Singleton
    Executor provideBackgroundExecutor() { return Executors.newFixedThreadPool(10);}

}
