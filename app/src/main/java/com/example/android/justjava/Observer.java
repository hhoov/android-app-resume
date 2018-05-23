package com.example.android.justjava;

public interface Observer {

    // Method to update the observer, used by subject
    void update();

    void onUserDataChanged();

    // Attach with subject to observe
    void setSubject(Subject subject);
}
