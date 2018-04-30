package com.example.android.justjava;

import android.os.Bundle;
import android.view.View;

/** ViewMVP with help from https://github.com/techyourchance/android_mvc_tutorial
 * MVP view interface.
 * Used for presenting information to the user.
 * Wraps one or more Android View's while adding logic for communication with MVP Controller.
 */
public interface ViewMVP {

    /**
     * Get the root Android View which is used internally by this MVP View for presenting data
     * to the user.
     * @return root Android View of this MVP View
     */
    View getRootView();

    /**
     * This method aggregates all the information about the state of this MVP View into Bundle
     * object. The keys in the returned Bundle must be provided as public constants inside the
     * interfaces (or implementations if no interface defined) of concrete MVP views.
     * @return Bundle containing the state of this MVC View, or null if the view has no state
     */
    Bundle getViewState();

}