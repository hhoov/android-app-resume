package com.example.android.justjava;

import android.app.Application;

public class MyApplication extends Application {
    static final ApplicationComponent applicationComponent;

    static {
        applicationComponent = DaggerApplicationComponent.builder()
                .okhttpModule(new OkhttpModule())
                .build();
    }

    static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
