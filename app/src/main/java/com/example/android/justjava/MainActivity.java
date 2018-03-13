package com.example.android.justjava;

/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match the package name found
 * in the project's AndroidManifest.xml file.
 **/


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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
    }

    /**
     * This method is called when the order button is clicked.
     */
    /*
    public void onClickEmail(View view) {
        sendEmail();
    }
*/
    /**
     * This method displays the given quantity value on the screen.
     */
    /*
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
*/

    /**
     * This method opens email application and fills out subject and body.
     */
    public void sendEmail() {

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_APP_EMAIL);
        Uri data = Uri.parse("mailto:recipient@example.com?subject=" + subject + "&body=" + body);
        intent.setData(data);
        startActivity(intent);
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