package com.example.android.justjava;

import android.app.Application;

public class MovieApplication extends Application {
    static final ApplicationComponent applicationComponent;

    static {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule())
                .build();
    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
