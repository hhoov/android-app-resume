package com.example.android.justjava;

import android.os.Handler;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;

public class UIExecutor implements Executor {

    private final Handler handler;

    UIExecutor(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void execute(@NonNull Runnable command) {
        handler.post(command);
    }
}
