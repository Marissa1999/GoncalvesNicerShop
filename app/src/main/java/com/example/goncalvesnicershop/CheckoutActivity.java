package com.example.goncalvesnicershop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class CheckoutActivity extends AppCompatActivity {

    //The tag to call the CheckoutActivity class name when debugging code
    private static final String CHECKOUT_LOG_TAG = CheckoutActivity.class.getSimpleName();

    /*
    Start the CheckoutActivity class with this auto-implemented method and extract monetary values from the MenuActivity class
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Launch the CheckoutActivity class and display the design on the screen
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        //Get the MenuActivity class intent before returning the needed values
        Intent menuIntent = getIntent();

        //Get the following monetary values from the activity tags in the MenuActivity class
        String finalAlbumSubtotal = menuIntent.getStringExtra(MenuActivity.FINAL_SUBTOTAL);
        String finalAlbumTPSTax = menuIntent.getStringExtra(MenuActivity.TPS_TAX);
        String finalAlbumTVQTax = menuIntent.getStringExtra(MenuActivity.TVQ_TAX);
        String finalAlbumTotal = menuIntent.getStringExtra(MenuActivity.FINAL_TOTAL);

        //Retrieve the TextView subtotal ID to insert the extracted subtotal value inside the element
        TextView finalSubtotal = findViewById(R.id.subtotal_number);
        finalSubtotal.setText(finalAlbumSubtotal);

        //Retrieve the TextView TPS tax ID to insert the extracted TPS tax value inside the element
        TextView finalTPSTax = findViewById(R.id.tps_total_number);
        finalTPSTax.setText(finalAlbumTPSTax);

        //Retrieve the TextView TVQ tax ID to insert the extracted TVQ tax value inside the element
        TextView finalTVQTax = findViewById(R.id.tvq_total_number);
        finalTVQTax.setText(finalAlbumTVQTax);

        //Retrieve the TextView total ID to insert the extracted total value inside the element
        TextView finalTotal = findViewById(R.id.final_total_number);
        finalTotal.setText(finalAlbumTotal);

        //Print a log message to ensure onCreate method's functionality
        Log.d(CHECKOUT_LOG_TAG, "Started CheckoutActivity and Transferred Values from MenuActivity");

    }

}
