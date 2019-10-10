package com.example.goncalvesnicershop;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.example.goncalvesnicershop.model.AlbumItem;
import java.util.LinkedList;

public class MenuActivity extends AppCompatActivity {

    //The tag to call the MenuActivity class name when debugging code
    private static final String MENU_LOG_TAG = MenuActivity.class.getSimpleName();

    //These tags set the variable names that will be transferred to the CheckoutActivity class
    public static final String FINAL_SUBTOTAL = "com.example.android.goncalvesnicershop.final.SUBTOTAL";
    public static final String TPS_TAX = "com.example.android.goncalvesnicershop.tps.TAX";
    public static final String TVQ_TAX = "com.example.android.goncalvesnicershop.tvq.TAX";
    public static final String FINAL_TOTAL = "com.example.android.goncalvesnicershop.final.TOTAL";


    private double totalTPSTax = 0.00;
    private double totalTVQTax = 0.00;
    private double finalTotal = 0.00;
    private double finalSubtotal = 0.00;


    private final LinkedList<AlbumItem> albumList = new LinkedList<>();
    private RecyclerView RecyclerView;
    private ProductAdapter Adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view)
            {

                final String[] shippingOptions = {"Express ($50)","Regular ($10)", "No Hurry (No Cost)"};

                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
                builder.setTitle("Choose a Shipping Option");

                int checkedItem = 0;
                builder.setSingleChoiceItems(shippingOptions, checkedItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position) {

                        switch(position)
                        {
                            case 0: break;
                            case 1: break;
                            case 2: break;
                        }

                    }
                });

                builder.setPositiveButton("Proceed to Checkout", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        launchCheckoutActivity(view);
                        dialog.dismiss();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }

        });



        AlbumItem albumItem1 = new AlbumItem(getResources().getString(R.string.album_title_1),
                getResources().getString(R.string.album_description_1),
                getResources().getDrawable(R.drawable.journey_escape),
                getResources().getString(R.string.album_price_1),
                getResources().getString(R.string.album_quantity_1), getResources().getString(R.string.album_subtotal_1));


        AlbumItem albumItem2 = new AlbumItem(getResources().getString(R.string.album_title_2),
                getResources().getString(R.string.album_description_2),
                getResources().getDrawable(R.drawable.the_who_tommy),
                getResources().getString(R.string.album_price_2),
                getResources().getString(R.string.album_quantity_2), getResources().getString(R.string.album_subtotal_2));


        AlbumItem albumItem3 = new AlbumItem(getResources().getString(R.string.album_title_3),
                getResources().getString(R.string.album_description_3),
                getResources().getDrawable(R.drawable.pearl_jam_ten),
                getResources().getString(R.string.album_price_3),
                getResources().getString(R.string.album_quantity_3), getResources().getString(R.string.album_subtotal_3));


        AlbumItem albumItem4 = new AlbumItem(getResources().getString(R.string.album_title_4),
                getResources().getString(R.string.album_description_4),
                getResources().getDrawable(R.drawable.nirvana_nevermind),
                getResources().getString(R.string.album_price_4),
                getResources().getString(R.string.album_quantity_4), getResources().getString(R.string.album_subtotal_4));


        AlbumItem albumItem5 = new AlbumItem(getResources().getString(R.string.album_title_5),
                getResources().getString(R.string.album_description_5),
                getResources().getDrawable(R.drawable.van_halen_1984),
                getResources().getString(R.string.album_price_5),
                getResources().getString(R.string.album_quantity_5), getResources().getString(R.string.album_subtotal_5));


        AlbumItem albumItem6 = new AlbumItem(getResources().getString(R.string.album_title_6),
                getResources().getString(R.string.album_description_6),
                getResources().getDrawable(R.drawable.u2_joshua_tree),
                getResources().getString(R.string.album_price_6),
                getResources().getString(R.string.album_quantity_6), getResources().getString(R.string.album_subtotal_6));


        AlbumItem albumItem7 = new AlbumItem(getResources().getString(R.string.album_title_7),
                getResources().getString(R.string.album_description_7),
                getResources().getDrawable(R.drawable.ac_dc_high_voltage),
                getResources().getString(R.string.album_price_7),
                getResources().getString(R.string.album_quantity_7), getResources().getString(R.string.album_subtotal_7));


        AlbumItem albumItem8 = new AlbumItem(getResources().getString(R.string.album_title_8),
                getResources().getString(R.string.album_description_8),
                getResources().getDrawable(R.drawable.yes_fragile),
                getResources().getString(R.string.album_price_8),
                getResources().getString(R.string.album_quantity_8), getResources().getString(R.string.album_subtotal_8));


        AlbumItem albumItem9 = new AlbumItem(getResources().getString(R.string.album_title_9),
                getResources().getString(R.string.album_description_9),
                getResources().getDrawable(R.drawable.rem_murmur),
                getResources().getString(R.string.album_price_9),
                getResources().getString(R.string.album_quantity_9), getResources().getString(R.string.album_subtotal_9));


        AlbumItem albumItem10 = new AlbumItem(getResources().getString(R.string.album_title_10),
                getResources().getString(R.string.album_description_10),
                getResources().getDrawable(R.drawable.pink_floyd_the_wall),
                getResources().getString(R.string.album_price_10),
                getResources().getString(R.string.album_quantity_10), getResources().getString(R.string.album_subtotal_10));


        this.albumList.addLast(albumItem1);
        this.albumList.addLast(albumItem2);
        this.albumList.addLast(albumItem3);
        this.albumList.addLast(albumItem4);
        this.albumList.addLast(albumItem5);
        this.albumList.addLast(albumItem6);
        this.albumList.addLast(albumItem7);
        this.albumList.addLast(albumItem8);
        this.albumList.addLast(albumItem9);
        this.albumList.addLast(albumItem10);


        this.RecyclerView = findViewById(R.id.recyclerView);
        this.Adapter = new ProductAdapter(this, this.albumList);
        this.RecyclerView.setAdapter(this.Adapter);
        this.RecyclerView.setLayoutManager(new LinearLayoutManager(this));

        if (savedInstanceState != null)
        {


        }

    }


    /*
        Calculate the chosen album's subtotal from implemented arguments
      */
    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    void showAlbumSubtotal(int albumQuantity, TextView idAlbumPrice, TextView albumSubtotal, View view) {

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

        sendMonetaryTotals();
    }


    /*
      Launch the CheckoutActivity class, which is supposed to be the following activity
     */
    @SuppressLint("DefaultLocale")
    public void launchCheckoutActivity(View view) {

        //Create an intent to start the following activity, which is MenuActivity
        Intent checkoutIntent = new Intent(this, CheckoutActivity.class);

        //Set the MenuActivity class formatted monetary values as tag names, in order for them to be used in the CheckoutActivity
        //These Double instance variables hold values for final purchase totals
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