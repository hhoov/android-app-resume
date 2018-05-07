package com.example.android.justjava;

import android.app.Application;

public class MyApplication extends Application {
    static final ApplicationComponent applicationComponent;

    static {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule())
                .build();
    }

    static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
