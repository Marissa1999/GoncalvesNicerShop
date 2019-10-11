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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.example.goncalvesnicershop.model.AlbumItem;
import java.util.LinkedList;

public class MenuActivity extends AppCompatActivity {


    private static final String MENU_LOG_TAG = MenuActivity.class.getSimpleName();
    public static final String FINAL_SUBTOTAL = "com.example.android.goncalvesnicershop.final.SUBTOTAL";


    private static double finalSubtotal = 0.00;

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
                            case 0: finalSubtotal += 50.00; break;
                            case 1: finalSubtotal += 10.00; break;
                            case 2: finalSubtotal += 0.00; break;
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

/*
        if (savedInstanceState != null)
        {
            String quantity = savedInstanceState.getString(String.valueOf(R.id.album_quantity));
            String subtotal = savedInstanceState.getString(String.valueOf(R.id.album_subtotal));

            if(this.albumQuantity != null)
            {
                this.albumQuantity.setText(quantity);
                this.albumSubtotal.setText(subtotal);
            }

        }
*/
    }

/*
    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putString(String.valueOf(R.id.album_quantity), String.valueOf(this.albumQuantity.getText()));
        outState.putString(String.valueOf(R.id.album_subtotal), String.valueOf(this.albumSubtotal.getText()));

    }
*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option_contact:
                Toast.makeText(getApplicationContext(), R.string.action_contact_message , Toast.LENGTH_SHORT).show();
                return true;
            case R.id.option_favorites:
                Toast.makeText(getApplicationContext(), R.string.action_favorites_message , Toast.LENGTH_SHORT).show();
                return true;
            case R.id.option_settings:
                Toast.makeText(getApplicationContext(), R.string.action_settings_message , Toast.LENGTH_SHORT).show();
                return true;
            case R.id.option_order:
                Toast.makeText(getApplicationContext(), R.string.action_order_message , Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    /*
      Launch the CheckoutActivity class, which is supposed to be the following activity
     */
    @SuppressLint("DefaultLocale")
    public void launchCheckoutActivity(View view) {

        Intent checkoutIntent = new Intent(this, CheckoutActivity.class);

        //String printedAlbumPrice = this.albumPrice.getText().toString().substring(1);
        //double albumPrice = Double.parseDouble(printedAlbumPrice);

        //String printedAlbumQuantity = this.albumQuantity.getText().toString().substring(1);
        //int albumQuantity = Integer.parseInt(printedAlbumQuantity);

       // double convertedAlbumSubtotal = albumPrice * albumQuantity;
        //finalSubtotal += convertedAlbumSubtotal;

       //if (this.albumSubtotal != null)
          // this.albumSubtotal.setText(String.format("$%.2f", convertedAlbumSubtotal));


        Log.d(MENU_LOG_TAG, "Displayed Album Subtotal");


        checkoutIntent.putExtra(FINAL_SUBTOTAL, String.format("$%.2f", finalSubtotal));


        startActivity(checkoutIntent);


        String launchingCheckoutMessage = "Button clicked!";
        Toast toastMenuMessage = Toast.makeText(this, launchingCheckoutMessage, Toast.LENGTH_SHORT);
        toastMenuMessage.show();


        Log.d(MENU_LOG_TAG, "Transferred Subtotal, Tax Values and Final Total to CheckoutActivity with Clicked Button");
    }


}