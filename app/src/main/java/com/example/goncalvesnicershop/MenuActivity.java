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
import android.widget.Toast;
import com.example.goncalvesnicershop.model.AlbumItem;
import java.util.ArrayList;
import java.util.LinkedList;

public class MenuActivity extends AppCompatActivity {

    //The tag to call the MenuActivity class name when debugging code.
    private static final String MENU_LOG_TAG = MenuActivity.class.getSimpleName();

    //These tags allow the monetary totals to be transferred to the CheckoutActivity class.
    public static final String ALBUM_SUBTOTAL = "com.example.android.goncalvesnicershop.album.SUBTOTAL";
    public static final String SHIPPING_TOTAL = "com.example.android.goncalvesnicershop.shipping.TOTAL";

    //These member variables calculate the monetary totals of the application.
    private double mFinalAlbumSubtotal = 0.00;
    private double mShippingTotal = 0.00;


    private final LinkedList<AlbumItem> mAlbumList = new LinkedList<>();
    protected RecyclerView mRecyclerView;
    protected ProductAdapter mAdapter;


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

                int checkedItem = -1;
                builder.setSingleChoiceItems(shippingOptions, checkedItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position) {

                        switch(position)
                        {
                            case 0: mShippingTotal += 50.00; break;
                            case 1: mShippingTotal += 10.00; break;
                            case 2: mShippingTotal += 0.00; break;
                        }

                    }
                });

                builder.setPositiveButton("Proceed to Checkout", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position) {
                        launchCheckoutActivity();
                        dialog.dismiss();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position) {
                        mShippingTotal -= mShippingTotal;
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


        this.mAlbumList.addLast(albumItem1);
        this.mAlbumList.addLast(albumItem2);
        this.mAlbumList.addLast(albumItem3);
        this.mAlbumList.addLast(albumItem4);
        this.mAlbumList.addLast(albumItem5);
        this.mAlbumList.addLast(albumItem6);
        this.mAlbumList.addLast(albumItem7);
        this.mAlbumList.addLast(albumItem8);
        this.mAlbumList.addLast(albumItem9);
        this.mAlbumList.addLast(albumItem10);

        this.mRecyclerView = findViewById(R.id.recyclerView);
        this.mAdapter = new ProductAdapter(this, this.mAlbumList);
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


    public void onSaveInstanceState (Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);

        ArrayList<String> savedAlbumList = new ArrayList<>();

        for(int retrievedElement = 0; retrievedElement < mAlbumList.size(); retrievedElement++)
        {
            savedAlbumList.add(mAlbumList.get(retrievedElement).getAlbumQuantity());
            savedAlbumList.add(mAlbumList.get(retrievedElement).getAlbumSubtotal());
            Log.d("Saving the quantity and subtotal from the " + retrievedElement + "element", savedAlbumList.get(retrievedElement));
        }

        savedInstanceState.putStringArrayList("Album ArrayList", savedAlbumList);
    }


    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);

        ArrayList<String> restoredAlbumList = savedInstanceState.getStringArrayList("Album ArrayList");

        for(int retrievedElement = 0, setterElement = 0; retrievedElement < mAlbumList.size(); retrievedElement++, setterElement += 2)
        {
            assert restoredAlbumList != null;
            mAlbumList.get(retrievedElement).setAlbumQuantity(restoredAlbumList.get(setterElement));
        }

        for(int retrievedElement = 0, setterElement = 1; retrievedElement < mAlbumList.size(); retrievedElement++, setterElement += 2)
        {
            mAlbumList.get(retrievedElement).setAlbumSubtotal(restoredAlbumList.get(setterElement));
        }


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.new_condition_option:
                Toast.makeText(getApplicationContext(), R.string.action_new_option_message , Toast.LENGTH_SHORT).show();
                return true;

            case R.id.like_new_condition_option:
                Toast.makeText(getApplicationContext(), R.string.action_like_new_message, Toast.LENGTH_SHORT).show();
                return true;

            case R.id.very_good_condition_option:
                Toast.makeText(getApplicationContext(), R.string.action_very_good_message , Toast.LENGTH_SHORT).show();
                return true;

            case R.id.good_condition_option:
                Toast.makeText(getApplicationContext(), R.string.action_good_message , Toast.LENGTH_SHORT).show();
                return true;

            case R.id.acceptable_condition_option:
                Toast.makeText(getApplicationContext(), R.string.action_acceptable_message, Toast.LENGTH_SHORT).show();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * Launch the CheckoutActivity class, which is supposed to be the following activity.
     */
    @SuppressLint("DefaultLocale")
    public void launchCheckoutActivity() {

        Intent checkoutIntent = new Intent(this, CheckoutActivity.class);

        for (int element = 0; element < this.mAlbumList.size(); element++)
        {
            double albumSubtotal = Double.parseDouble(this.mAlbumList.get(element).getAlbumSubtotal().substring(1));
            mFinalAlbumSubtotal += albumSubtotal;
        }

        checkoutIntent.putExtra(ALBUM_SUBTOTAL, String.format("$%.2f", mFinalAlbumSubtotal));
        checkoutIntent.putExtra(SHIPPING_TOTAL, String.format("$%.2f", mShippingTotal));

        startActivity(checkoutIntent);

        String launchingCheckoutMessage = "Button clicked!";
        Toast toastButtonMessage = Toast.makeText(this, launchingCheckoutMessage, Toast.LENGTH_SHORT);
        toastButtonMessage.show();

        Log.d(MENU_LOG_TAG, "Transferred Subtotal to CheckoutActivity with Clicked Button");
    }


}