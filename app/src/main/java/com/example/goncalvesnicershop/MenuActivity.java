package com.example.goncalvesnicershop;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {


    //The tag to call the MenuActivity class name when debugging code
    private static final String MENU_LOG_TAG = MenuActivity.class.getSimpleName();

    //These tags set the variable names that will be transferred to the CheckoutActivity class
    public static final String FINAL_SUBTOTAL = "com.example.android.goncalvesshop.extra.MESSAGE";
    public static final String TPS_TAX = "com.example.android.goncalvesshop.tps.TAX";
    public static final String TVQ_TAX = "com.example.android.goncalvesshop.tvq.TAX";
    public static final String FINAL_TOTAL = "com.example.android.goncalvesshop.final.TOTAL";

    //These Double instance variables hold values for final purchase totals
    private double finalSubtotal = 0.00;
    private double totalTPSTax = 0.00;
    private double totalTVQTax = 0.00;
    private double finalTotal = 0.00;

    //These TextView instance variables hold the String added quantity value for each CardView element
    private TextView showAddedAlbumQuantity;

    //These TextView instance variables hold the album price for each CardView element
    private TextView albumPrice;

    //These TextView instance variables hold the String subtracted quantity value for each CardView element
    private TextView showSubtractedAlbumQuantity;

    //These TextView instance variables hold the album quantity for each CardView element
    private int albumQuantity = 0;

    //These TextView instance variables hold the String subtotal value for each CardView element
    private TextView showAlbumSubtotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        this.showAddedAlbumQuantity = findViewById(R.id.album_quantity_1);
        this.showSubtractedAlbumQuantity = findViewById(R.id.album_quantity_1);
        this.showAlbumSubtotal = findViewById(R.id.album_subtotal_1);

    }


    /*
    Modifies the first album's quantity value when the increment button is clicked
     */
    @SuppressLint("SetTextI18n")
    public void addAlbumQuantity(View view) {

        //Determine the first album price from the specified ID
        this.albumPrice = findViewById(R.id.album_price_1);

        //Increment the first album quantity by 1
        this.albumQuantity++;

        //If the first album quantity is less than 0, the quantity should remain at 0
        if (this.albumQuantity < 0) {
            this.albumQuantity = 0;
        }

        //Convert the first album quantity Integer value to a String value and set it to the TextView first album quantity element
        if (this.showAddedAlbumQuantity != null)
            this.showAddedAlbumQuantity.setText(Integer.toString(this.albumQuantity));

        //Print a log message to ensure addAlbumQuantity1 method's functionality
        Log.d(MENU_LOG_TAG, "Added Quantity to First Album");

        //Call this method to calculate the first album's subtotal according to implemented arguments
        showAlbumSubtotal(this.albumQuantity, this.albumPrice, this.showAlbumSubtotal);

    }



    /*
    Modifies the first album's quantity value when the decrement button is clicked
     */
    @SuppressLint("SetTextI18n")
    public void subtractAlbumQuantity1(View view) {

        //Determine the first album price from the specified ID
        this.albumPrice = findViewById(R.id.album_price_1);

        //Decrement the first album quantity by 1
        this.albumQuantity--;

        //If the first album quantity is less than 0, the quantity should remain at 0
        if (this.albumQuantity < 0) {
            this.albumQuantity = 0;
        }

        //Convert the first album quantity Integer value to a String value and set it to the TextView first album quantity element
        if (this.showSubtractedAlbumQuantity != null)
            this.showSubtractedAlbumQuantity.setText(Integer.toString(this.albumQuantity));

        //Print a log message to ensure subtractAlbumQuantity1 method's functionality
        Log.d(MENU_LOG_TAG, "Added Quantity to First Album");

        //Call this method to calculate the first album's subtotal according to implemented arguments
        showAlbumSubtotal(this.albumQuantity, this.albumPrice, this.showAlbumSubtotal);

    }

    /*
   Calculate the chosen album's subtotal from implemented arguments
    */
    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    public void showAlbumSubtotal(int albumQuantity, TextView idAlbumPrice, TextView albumSubtotal) {

        //Get the album price by converted the TextView element to a String value
        String printedAlbumPrice = idAlbumPrice.getText().toString().substring(1);

        //Convert the String album price value to a Double value
        double albumPrice = Double.parseDouble(printedAlbumPrice);

        //Calculate the subtotal by multiplying the album price and quantity
        double convertedAlbumSubtotal = albumPrice * albumQuantity;

        //Set the formatted album subtotal to the TextView album subtotal
        if (albumSubtotal != null)
            albumSubtotal.setText(String.format("$%.2f", convertedAlbumSubtotal));


        //Print a log message to ensure showAlbumSubtotal method's functionality
        Log.d(MENU_LOG_TAG, "Displayed Album Subtotal");

        //Call this method to calculate the final album subtotal
        calculateAlbumFinalSubtotal(convertedAlbumSubtotal);

        //Call this method to calculate the final album taxes
        calculateAlbumFinalTotalTaxes();

        //Call this method to calculate the final album total
        calculateAlbumFinalTotal();
    }


    /*
    Calculate the final subtotal instance variable
     */
    public void calculateAlbumFinalSubtotal(double albumSubtotal) {

        //Determine the final subtotal value by adding the CardView album subtotal to the variable
        this.finalSubtotal += albumSubtotal;

        //Print a log message to ensure calculateAlbumFinalSubtotal method's functionality
        Log.d(MENU_LOG_TAG, "Calculated Album Final Subtotal");
    }


    /*
    Calculate the instance variable values for both Canadian taxes
     */
    public void calculateAlbumFinalTotalTaxes() {

        //Determine the final subtotal value by adding the CardView album subtotal to the variable
        this.totalTPSTax = this.finalSubtotal * 0.05;
        this.totalTVQTax = this.finalSubtotal * 0.0975;

        //Print a log message to ensure calculateAlbumFinalTotalTaxes method's functionality
        Log.d(MENU_LOG_TAG, "Calculated Album Final Subtotal Taxes");
    }


    /*
    Calculate the final subtotal instance variable
     */
    public void calculateAlbumFinalTotal() {

        //Determine the final total value by adding the album subtotal and tax totals together
        this.finalTotal = this.finalSubtotal + this.totalTPSTax + this.totalTVQTax;

        //Print a log message to ensure calculateAlbumFinalTotal method's functionality
        Log.d(MENU_LOG_TAG, "Calculated Album Final Total");
    }


    /*
      Launch the CheckoutActivity class, which is supposed to be the following activity
     */
    @SuppressLint("DefaultLocale")
    public void launchCheckoutActivity(View view) {

        //Create an intent to start the following activity, which is MenuActivity
        Intent checkoutIntent = new Intent(this, CheckoutActivity.class);

        //Set the MenuActivity class formatted monetary values as tag names, in order for them to be used in the CheckoutActivity
        checkoutIntent.putExtra(FINAL_SUBTOTAL, String.format("$%.2f", this.finalSubtotal));
        checkoutIntent.putExtra(TPS_TAX, String.format("$%.2f", this.totalTPSTax));
        checkoutIntent.putExtra(TVQ_TAX, String.format("$%.2f", this.totalTVQTax));
        checkoutIntent.putExtra(FINAL_TOTAL, String.format("$%.2f", this.finalTotal));

        //Start the CheckoutActivity class and send a text request at the same time
        startActivity(checkoutIntent);

        String launchingMenuMessage = "Button clicked!";
        Toast toastMenuMessage = Toast.makeText(this, launchingMenuMessage, Toast.LENGTH_SHORT);
        toastMenuMessage.show();

        //Print a log message to ensure launchCheckoutActivity method's functionality
        Log.d(MENU_LOG_TAG, "Transferred Subtotal, Tax Values and Final Total to CheckoutActivity with Clicked Button");
    }


}