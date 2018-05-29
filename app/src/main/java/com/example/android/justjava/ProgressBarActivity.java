package com.example.android.justjava;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ProgressBarActivity extends AppCompatActivity {
    private TextView txtProgress;
    private ProgressProvider progressBar;
    private ItemViewsPresenter itemViewsPresenter;
    private int progressStatus = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        txtProgress = findViewById(R.id.txtProgress);
        //progressBar = findViewById(R.id.progressBar);
        progressBar.addObserver(itemViewsPresenter);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressStatus <= 100) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progressStatus);
                            txtProgress.setText(String.format(String.valueOf(progressStatus), "%d %%"));
                        }
                    });
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progressStatus++;
                }
            }
        }).start();

    }
}
