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

    private double finalAlbumSubtotal = 0.00;
    private double shippingTotal = 0.00;
    private double finalSubtotal = 0.00;
    private double totalTPSTax = 0.00;
    private double totalTVQTax = 0.00;
    private double finalTotal = 0.00;


    /*
    Start the CheckoutActivity class with this auto-implemented method and extract monetary values from the MenuActivity class
    */
    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);


        Intent menuIntent = getIntent();

        String finalAlbumSubtotalText = menuIntent.getStringExtra(MenuActivity.FINAL_SUBTOTAL);
        this.finalAlbumSubtotal = Double.parseDouble(finalAlbumSubtotalText.substring(1));

        String finalAlbumShippingTotalText = menuIntent.getStringExtra(MenuActivity.SHIPPING_TOTAL);
        this.shippingTotal = Double.parseDouble(finalAlbumShippingTotalText.substring(1));

        this.finalSubtotal = this.finalAlbumSubtotal + this.shippingTotal;
        this.totalTPSTax = this.finalSubtotal * 0.05;
        this.totalTVQTax = this.finalSubtotal * 0.0975;
        this.finalTotal = this.totalTPSTax + this.totalTVQTax + this.finalSubtotal;


        Log.d(CHECKOUT_LOG_TAG, "Calculated Album Final Subtotal, Taxes and Final Total");


        //Retrieve the TextView subtotal ID to insert the extracted subtotal value inside the element
        TextView finalAlbumSubtotal = findViewById(R.id.subtotal_number);
        finalAlbumSubtotal.setText(String.format("$%.2f", this.finalAlbumSubtotal));

        //Retrieve the TextView subtotal ID to insert the extracted subtotal value inside the element
        TextView shippingTotal = findViewById(R.id.shipping_total_number);
        shippingTotal.setText(String.format("$%.2f", this.shippingTotal));

        //Retrieve the TextView subtotal ID to insert the extracted subtotal value inside the element
        TextView finalSubtotal = findViewById(R.id.final_subtotal_number);
        finalSubtotal.setText(String.format("$%.2f", this.finalSubtotal));

        //Retrieve the TextView TPS tax ID to insert the extracted TPS tax value inside the element
        TextView finalTPSTax = findViewById(R.id.tps_total_number);
        finalTPSTax.setText(String.format("$%.2f", this.totalTPSTax));

        //Retrieve the TextView TVQ tax ID to insert the extracted TVQ tax value inside the element
        TextView finalTVQTax = findViewById(R.id.tvq_total_number);
        finalTVQTax.setText(String.format("$%.2f", this.totalTVQTax));

        //Retrieve the TextView total ID to insert the extracted total value inside the element
        TextView finalTotal = findViewById(R.id.final_total_number);
        finalTotal.setText(String.format("$%.2f", this.finalTotal));


        //Print a log message to ensure onCreate method's functionality
        Log.d(CHECKOUT_LOG_TAG, "Started CheckoutActivity and Transferred Values from MenuActivity");

    }

}
