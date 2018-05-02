package com.example.android.justjava;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {
    //todo
    private final Activity mActivity;

    public PresenterModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    Context context() {
        return mActivity;
    }

    @Provides
    Activity activity() {
        return mActivity;
    }
}
