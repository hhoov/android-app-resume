package com.example.android.justjava;

/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match the package name found
 * in the project's AndroidManifest.xml file.
 **/


import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    String subject = "Internship";
    String body = "Hi Hannah,\n Great work! When would you like to start your internship?";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendEmail();
    }



    /**
     * This method opens email application and fills out subject and body.
     */
    public void sendEmail() {

        // Build the intent
        Uri data = Uri.parse("mailto:recipient@example.com?subject=" + subject + "&body=" + body);
        Intent emailIntent = new Intent(Intent.ACTION_MAIN);
        emailIntent.addCategory(Intent.CATEGORY_APP_EMAIL);
        emailIntent.setData(data);
        //emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"jon@example.com"}); // recipients
        //emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
        //emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message text");

        // Verify the app exists to handle the intent
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(emailIntent, 0);
        boolean isIntentSafe = activities.size() > 0;

        // Start activity if it is safe to do so
        if (isIntentSafe) {
            startActivity(emailIntent);
        }
        /*
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_APP_EMAIL);
        startActivity(intent);
        */
        /*
        Intent intent = getPackageManager().getLaunchIntentForPackage("com.android.email");
        startActivity(intent);
        */
    }
}