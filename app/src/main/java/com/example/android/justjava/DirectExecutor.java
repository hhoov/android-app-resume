package com.example.android.justjava;

import android.support.annotation.NonNull;

public class DirectExecutor extends UIExecutor {

    DirectExecutor() {
        super(null);
    }

    @Override
    public void execute(@NonNull Runnable command) {
        command.run();

    }
}
