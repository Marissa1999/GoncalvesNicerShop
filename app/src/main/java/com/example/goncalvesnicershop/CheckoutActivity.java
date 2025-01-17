package com.example.goncalvesnicershop;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class CheckoutActivity extends AppCompatActivity {

    //The tag to call the CheckoutActivity class name when debugging code.
    private static final String CHECKOUT_LOG_TAG = CheckoutActivity.class.getSimpleName();

    //These variables calculate the final monetary totals of the application.
    protected double finalAlbumSubtotal = 0.00;
    protected double finalShippingTotal = 0.00;
    protected double finalSubtotal = 0.00;
    protected double totalTPSTax = 0.00;
    protected double totalTVQTax = 0.00;
    protected double finalTotal = 0.00;


    /**
     * Start the CheckoutActivity class with this auto-implemented method and calculate the final monetary totals of the application.
     *
     * @param savedInstanceState The Bundle values for displaying all data on the device.
     */
    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Launch the CheckoutActivity class and display the design on the screen.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        //Get the MenuActivity class intent before returning the needed values.
        Intent menuIntent = getIntent();

        //Get the album subtotal value from the activity tag in the MenuActivity class.
        String finalAlbumSubtotalText = menuIntent.getStringExtra(MenuActivity.TOTAL_ALBUM_SUBTOTAL);
        this.finalAlbumSubtotal = Double.parseDouble(finalAlbumSubtotalText.substring(1));

        //Get the shipping total value from the activity tag in the MenuActivity class.
        String finalAlbumShippingTotalText = menuIntent.getStringExtra(MenuActivity.SHIPPING_TOTAL);
        this.finalShippingTotal = Double.parseDouble(finalAlbumShippingTotalText.substring(1));

        //Calculate the final monetary totals from the extracted values from the MenuActivity class.
        this.finalSubtotal = this.finalAlbumSubtotal + this.finalShippingTotal;
        this.totalTPSTax = this.finalSubtotal * 0.05;
        this.totalTVQTax = this.finalSubtotal * 0.0975;
        this.finalTotal = this.totalTPSTax + this.totalTVQTax + this.finalSubtotal;

        //Print a log message to mention that all monetary totals have been calculated.
        Log.d(CHECKOUT_LOG_TAG, "Calculated the Final Subtotal, Taxes and Final Total");


        //Retrieve the TextView subtotal ID to insert the extracted subtotal value inside the element.
        TextView finalAlbumSubtotal = findViewById(R.id.subtotal_number);
        finalAlbumSubtotal.setText(String.format("$%.2f", this.finalAlbumSubtotal));

        //Retrieve the TextView shipping total ID to insert the extracted shipping total value inside the element.
        TextView finalShippingTotal = findViewById(R.id.shipping_total_number);
        finalShippingTotal.setText(String.format("$%.2f", this.finalShippingTotal));

        //Retrieve the TextView final subtotal ID to insert the extracted final subtotal value inside the element.
        TextView finalSubtotal = findViewById(R.id.final_subtotal_number);
        finalSubtotal.setText(String.format("$%.2f", this.finalSubtotal));

        //Retrieve the TextView TPS tax ID to insert the extracted TPS tax value inside the element.
        TextView finalTPSTax = findViewById(R.id.tps_total_number);
        finalTPSTax.setText(String.format("$%.2f", this.totalTPSTax));

        //Retrieve the TextView TVQ tax ID to insert the extracted TVQ tax value inside the element.
        TextView finalTVQTax = findViewById(R.id.tvq_total_number);
        finalTVQTax.setText(String.format("$%.2f", this.totalTVQTax));

        //Retrieve the TextView total ID to insert the extracted total value inside the element.
        TextView finalTotal = findViewById(R.id.final_total_number);
        finalTotal.setText(String.format("$%.2f", this.finalTotal));


        //Print a log message to ensure onCreate method's functionality.
        Log.d(CHECKOUT_LOG_TAG, "Started CheckoutActivity and Transferred Needed Values from MenuActivity");

    }

}
