package com.example.goncalvesnicershop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //The tag to call the MainActivity class name when debugging code.
    private static final String MAIN_LOG_TAG = MainActivity.class.getSimpleName();

    /**
     * Starts the MainActivity class with this auto-implemented method.
     *
     * @param savedInstanceState The Bundle value for displaying all data on the device.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Launch the MainActivity class and display the design on the screen.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Print a log message to ensure onCreate method's functionality.
        Log.d(MAIN_LOG_TAG, "Started the MainActivity.");
    }


    /**
     * Launches the MenuActivity class, which is supposed to be the following activity.
     *
     * @param view The View element that has been triggered.
     */
    public void launchMenuActivity(View view) {

        //Create an intent to start the following activity, which is MenuActivity class.
        Intent menuIntent = new Intent(this, MenuActivity.class);

        //Start the MenuActivity class.
        startActivity(menuIntent);

        //Create a Toast message which responds to the MainActivity's button.
        String launchingMainMessage = "Welcome to My Music Collection!";
        Toast toastMainMessage = Toast.makeText(this, launchingMainMessage, Toast.LENGTH_SHORT);
        toastMainMessage.show();

        //Print a log message to ensure launchMenuActivity method's functionality.
        Log.d(MAIN_LOG_TAG, "Launched the MenuActivity with Clicked Button.");
    }


}
