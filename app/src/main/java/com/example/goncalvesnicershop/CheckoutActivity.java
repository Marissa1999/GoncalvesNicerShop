package com.example.goncalvesnicershop;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class CheckoutActivity extends AppCompatActivity {

    //The tag to call the CheckoutActivity class name when debugging code
    private static final String CHECKOUT_LOG_TAG = CheckoutActivity.class.getSimpleName();

    private final String TPS_TAX = "com.example.android.goncalvesnicershop.tps.TAX";
    public final String TVQ_TAX = "com.example.android.goncalvesnicershop.tvq.TAX";
    public final String FINAL_TOTAL = "com.example.android.goncalvesnicershop.final.TOTAL";

    private double totalTPSTax = 0.00;
    private double totalTVQTax = 0.00;
    private double finalTotal = 0.00;

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


            //Determine the final subtotal value by adding the CardView album subtotal to the variable

            this.totalTPSTax = finalAlbumSubtotal * 0.05;
            this.totalTVQTax = finalAlbumSubtotal * 0.0975;

            //Print a log message to ensure calculateAlbumFinalTotalTaxes method's functionality
            Log.d(CHECKOUT_LOG_TAG, "Calculated Album Final Subtotal Taxes");


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


            //Create an intent to start the following activity, which is MenuActivity
            Intent menuIntent = new Intent(this, MenuActivity.class);

            //Set the MenuActivity class formatted monetary values as tag names, in order for them to be used in the CheckoutActivity
            //These Double instance variables hold values for final purchase totals
            menuIntent.putExtra(FINAL_SUBTOTAL, String.format("$%.2f", this.finalSubtotal));
            menuIntent.putExtra(TPS_TAX, String.format("$%.2f", this.totalTPSTax));
            menuIntent.putExtra(TVQ_TAX, String.format("$%.2f", this.totalTVQTax));
            menuIntent.putExtra(FINAL_TOTAL, String.format("$%.2f", this.finalTotal));

            //Print a log message to ensure launchCheckoutActivity method's functionality
            Log.d(ADAPTER_LOG_TAG, "Transferred Subtotal, Tax Values and Final Total to CheckoutActivity with Clicked Button");


        //Print a log message to ensure onCreate method's functionality
        Log.d(CHECKOUT_LOG_TAG, "Started CheckoutActivity and Transferred Values from MenuActivity");

    }

}
