package com.example.android.justjava;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class NavigationDrawerDelegate {
    private final AppCompatActivity activity;
    private final DrawerLayout drawerLayout;
    private final Toolbar toolbar;
    private final NavigationView navView;

    NavigationDrawerDelegate(AppCompatActivity activity, DrawerLayout drawerLayout, Toolbar toolbar, NavigationView navView) {
        this.activity = activity;
        this.drawerLayout = drawerLayout;
        this.toolbar = toolbar;
        this.navView = navView;
    }

    void setupNavDrawer() {

        // Set a Toolbar to replace the Actionbar
        activity.setSupportActionBar(toolbar);

        // Set up drawer view
        ActionBar actionbar = activity.getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                activity, drawerLayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        //drawer.setDrawerListener(toggle);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        // Set item as selected to persist highlight
                        menuItem.setChecked(true);

                        switch(menuItem.getItemId()) {
                            case R.id.nav_movies_list:
                                activity.startActivity(new Intent(activity, MoviesListActivity.class));
                                return true;
                            case R.id.nav_movies_grid:
                                activity.startActivity(new Intent(activity, MoviesGridActivity.class));
                                return true;
                            case R.id.app_name:
                                activity.startActivity(new Intent(activity, MainActivity.class));
                                return true;
                        }

                        // Close drawer when item is tapped
                        drawerLayout.closeDrawers();

                        return true;
                    }
                });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return false;
    }
}
