package com.example.android.justjava;

/*
  IMPORTANT: Make sure you are using the correct package name.
  This example uses the package name:
  package com.example.android.justjava
  If you get an error when copying this code into Android studio, update it to match the package name found
  in the project's AndroidManifest.xml file.
 */


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

/**
 * This app displays a resume, email button, and navigation drawer.
 */
public class MainActivity extends AppCompatActivity {
    String[] recipient = {"hannahghoover@gmail.com"};
    private NavigationDrawerDelegate navDrawerDelegate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        NavigationView navView = findViewById(R.id.nav_view);
        navDrawerDelegate = new NavigationDrawerDelegate(this, drawerLayout, toolbar, navView);
        navDrawerDelegate.setupNavDrawer();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return navDrawerDelegate.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    /**
     * This method opens email application and fills out subject and body.
     */
    public void sendEmail(View view) {

        // Build the intent
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, recipient);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, R.string.email_subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, R.string.email_body);

        emailIntent.setType("text/plain");
        startActivity(Intent.createChooser(emailIntent, getString(R.string.email_app_prompt_title)));

//        // Verify the app exists to handle the intent
//        PackageManager packageManager = getPackageManager();
//        List<ResolveInfo> activities = packageManager.queryIntentActivities(emailIntent, 0);
//        boolean isIntentSafe = activities.size() > 0;
//
//        // Start activity if it is safe to do so
//        if (isIntentSafe) {
//            startActivity(Intent.createChooser(emailIntent, "Send your email in:"));
//        }
    }

}