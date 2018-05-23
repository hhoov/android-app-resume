package com.example.android.justjava;

public interface Subject {

    // Methods to register and unregister, or remove, observers
    void registerObserver(Observer observer);
    void unregisterObserver(Observer observer);

    // Method to notify observers of change
    void notifyObservers();

    // Method to get updates from subject
    Object getUpdate(Observer observer);
}
