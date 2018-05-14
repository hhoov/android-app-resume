package com.example.android.justjava;

import android.support.annotation.NonNull;

import java.util.concurrent.Executor;

public class DirectExecutor implements Executor {

    @Override
    public void execute(@NonNull Runnable command) {
        command.run();

    }
}
