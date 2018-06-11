package com.example.android.justjava;

import java.util.ArrayList;

/**
 * Provides methods to add/delete observers
 * Provides methods to notify all observers
 * A subclass only needs to ensure that its observers are notified in the appropriate mutators
 * Uses a Vector for storing the observer references
 */
class MyObservable {
    private boolean changed;
    private ArrayList<MyObserver> observersList;
    private final Object MUTEX = new Object();

    // Constructs an Observable with zero Observers
    MyObservable() {
        observersList = new ArrayList<>();
    }

    /**
     * Adds an observer to the set of observers for this object, provided
     * that it is not the same as some observer already in the set.
     *
     * @param   observer   an observer to be added.
     * @throws NullPointerException   if the parameter is null.
     */
    // Adds an observer to the set of observers of this object
    public void registerObserver(MyObserver observer) {
        if (observer == null)
            throw new NullPointerException();
        synchronized (MUTEX) {
            if (!observersList.contains(observer)) {
                observersList.add(observer);
            }
        }
    }

    /**
     * Deletes an observer from the set of observers of this object.
     *
     * @param   observer   the observer to be deleted.
     */
    // Deletes an observer from the set of observers of this object
    public void deregisterObserver(MyObserver observer) {
        synchronized (MUTEX) {
            if (observer != null) {
                observersList.remove(observer);
            }
        }
    }

    /**
     * If this object has changed, as indicated by the
     * <code>hasChanged</code> method, then notify all of its observers
     * and then call the <code>clearChanged</code> method to indicate
     * that this object has no longer changed.
     * <p>
     * Each observer has its <code>update</code> method called with two
     * arguments: this observable object and the <code>arg</code> argument.
     * <p>
     *The arg argument can be used to indicate which attribute of the observable
     * object has changed.
     *
     * @param   arg   any object.
     */

    void notifyObservers(Object arg) {
        /*
         * a temporary array buffer, used as a snapshot of the state of
         * current Observers.
         */
        ArrayList<MyObserver> observersLocal;

        // Synchronization is used to make sure any observer registered after message is received
        // is not notified.
        synchronized (MUTEX) {
            // Android-changed: Call out to hasChanged() to figure out if something changes.
            // Upstream code avoids calling the nonfinal hasChanged() from the synchronized block,
            // but that would break compatibility for apps that override that method.
            // if (!changed)
            if (!hasChanged())
                return;
            observersLocal = new ArrayList<>(this.observersList);
            clearChanged();
        }


        for (MyObserver observer : observersLocal) {
            observer.onProgressUpdated(this, arg);
        }
    }

    /** Marks Observable object as changed, so hasChanged() will return true */
    // Indicates that this object has changed
    synchronized void setChanged() {
        changed = true;
    }

    /**
     * Indicates that this object has no longer changed, or that it has
     * already notified all of its observers of its most recent change,
     * so that the <tt>hasChanged</tt> method will now return <tt>false</tt>.
     * This method is called automatically by the
     * <code>notifyObservers</code> methods.
     */
    // Indicates that this object has no longer changed, or that it has already
    // notified all of its observers of its most recent change. This method is called
    // automatically by notifyObservers().
    private synchronized void clearChanged() {
        changed = false;
    }

    /**
     * Tests if object has changed.
     * true -- iff setChanged() has been called more recently than
     *          clearChanged() on this object
     * false -- otherwise.
     */
    private synchronized boolean hasChanged() {
        return changed;
    }








    /**
     * Clears the observer list so that this object no longer has any observers.
     * TODO: .clear() clears an instance of the class. .removeAll() removes all the given
     *      objects and returns the state of the operation (is slower than clear(). O(n**2) vs O(n))
     */
    public synchronized void clearObservers() {
        observersList.clear();
    }

    /** Returns the number of observers of the Observable object */
    public synchronized int countObservers() {
        return observersList.size();
    }


}


