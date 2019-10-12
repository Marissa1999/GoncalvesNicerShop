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
    public static final String TOTAL_ALBUM_SUBTOTAL = "com.example.android.goncalvesnicershop.album.SUBTOTAL";
    public static final String SHIPPING_TOTAL = "com.example.android.goncalvesnicershop.shipping.TOTAL";

    //These member variables calculate the monetary totals of the application.
    private double mTotalAlbumSubtotal = 0.00;
    private double mShippingTotal = 0.00;

    //These member variables host the data to be displayed in the RecyclerView.
    private final LinkedList<AlbumItem> mAlbumList = new LinkedList<>();
    protected RecyclerView mRecyclerView;
    protected ProductAdapter mAdapter;


    /**
     * Starts the MainActivity class with this auto-implemented method, creates the RecyclerView and triggers buttons.
     *
     * @param savedInstanceState The Bundle values for displaying all data on the device.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Launch the MainActivity class and display the design on the screen.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Create a toolbar for the class, since MenuActivity is a basic activity.
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Create a floating action button, since MenuActivity is a basic activity.
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            /**
             * Identifies actions based on the clicked floating action button.
             *
             * @param view The View of the clicked radio button.
             */
            @Override
            public void onClick(View view) {

                //Create a String array of options for shipping.
                final String[] shippingOptions = {"Express ($50)", "Regular ($10)", "No Hurry (No Cost)"};

                //Create an alert dialog, when the floating action button is triggered.
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);

                //Set the title of the alert dialog.
                builder.setTitle("Choose a Shipping Option");

                //Allow none of the items to be checked when triggering the dialog.
                int checkedItem = -1;

                //Create radio buttons for the application user to choose a shipping option.
                builder.setSingleChoiceItems(shippingOptions, checkedItem, new DialogInterface.OnClickListener() {

                    /**
                     * Presents a selection of delivery methods.
                     * @param dialog The DialogInterface that received the radio button click.
                     * @param position The radio button that was clicked.
                     */
                    @Override
                    public void onClick(DialogInterface dialog, int position) {

                        //Based on the radio button's position,
                        switch (position) {
                            //If the first radio button was clicked, proceed with the following step.
                            case 0: {
                                //Set the shipping total to $50.00.
                                mShippingTotal = 50.00;
                            }
                            break;

                            //If the second radio button was clicked, proceed with the following step.
                            case 1: {
                                //Set the shipping total to $10.00.
                                mShippingTotal = 10.00;
                            }
                            break;

                            //If the third radio button was clicked, proceed with the following step.
                            case 2: {
                                //Set the shipping total to $0.00.
                                mShippingTotal = 0.00;
                            }
                            break;
                        }

                    }
                });

                //Create a button that agrees and proceeds to checkout with the radio button selection.
                builder.setPositiveButton("Proceed to Checkout", new DialogInterface.OnClickListener() {

                    /**
                     * Proceeds to checkout by calling the launchCheckoutActivity method.
                     * @param dialog The DialogInterface that received the button click.
                     * @param position The button that was clicked.
                     */
                    @Override
                    public void onClick(DialogInterface dialog, int position) {

                        //Call the method to calculate the monetary totals and launch the CheckoutActivity class.
                        launchCheckoutActivity();

                        //Remove the dialog when the button is triggered.
                        dialog.dismiss();
                    }
                });

                //Create a button cancels the checkout and sets the shipping total back to $0.00.
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                    /**
                     * Cancels the checkout and initializes the shipping total back to $0.00.
                     * @param dialog The DialogInterface that received the button click.
                     * @param position The button that was clicked.
                     */
                    @Override
                    public void onClick(DialogInterface dialog, int position) {

                        //Set the shipping total to $0.00.
                        mShippingTotal = 0.00;

                        //Remove the dialog when the button is triggered.
                        dialog.dismiss();
                    }
                });

                //Create the dialog based on the items listed in the builder variable.
                AlertDialog dialog = builder.create();

                //Show the dialog in the application.
                dialog.show();
            }

        });


        /*
          Create 10 unique album item objects to store in the data set.
         */

        //Create the first album called "Escape" by Journey.
        AlbumItem albumItem1 = new AlbumItem(getResources().getString(R.string.album_title_1),
                getResources().getString(R.string.album_description_1),
                getResources().getDrawable(R.drawable.journey_escape),
                getResources().getString(R.string.album_price_1),
                getResources().getString(R.string.album_quantity_1),
                getResources().getString(R.string.album_subtotal_1));

        //Create the second album called "Tommy" by The Who.
        AlbumItem albumItem2 = new AlbumItem(getResources().getString(R.string.album_title_2),
                getResources().getString(R.string.album_description_2),
                getResources().getDrawable(R.drawable.the_who_tommy),
                getResources().getString(R.string.album_price_2),
                getResources().getString(R.string.album_quantity_2),
                getResources().getString(R.string.album_subtotal_2));

        //Create the third album called "Ten" by Pearl Jam.
        AlbumItem albumItem3 = new AlbumItem(getResources().getString(R.string.album_title_3),
                getResources().getString(R.string.album_description_3),
                getResources().getDrawable(R.drawable.pearl_jam_ten),
                getResources().getString(R.string.album_price_3),
                getResources().getString(R.string.album_quantity_3),
                getResources().getString(R.string.album_subtotal_3));

        //Create the fourth album called "Nevermind" by Nirvana.
        AlbumItem albumItem4 = new AlbumItem(getResources().getString(R.string.album_title_4),
                getResources().getString(R.string.album_description_4),
                getResources().getDrawable(R.drawable.nirvana_nevermind),
                getResources().getString(R.string.album_price_4),
                getResources().getString(R.string.album_quantity_4),
                getResources().getString(R.string.album_subtotal_4));

        //Create the fifth album called "1984" by Van Halen.
        AlbumItem albumItem5 = new AlbumItem(getResources().getString(R.string.album_title_5),
                getResources().getString(R.string.album_description_5),
                getResources().getDrawable(R.drawable.van_halen_1984),
                getResources().getString(R.string.album_price_5),
                getResources().getString(R.string.album_quantity_5),
                getResources().getString(R.string.album_subtotal_5));

        //Create the sixth album called "The Joshua Tree" by U2.
        AlbumItem albumItem6 = new AlbumItem(getResources().getString(R.string.album_title_6),
                getResources().getString(R.string.album_description_6),
                getResources().getDrawable(R.drawable.u2_joshua_tree),
                getResources().getString(R.string.album_price_6),
                getResources().getString(R.string.album_quantity_6),
                getResources().getString(R.string.album_subtotal_6));

        //Create the seventh album called "High Voltage" by AC/DC.
        AlbumItem albumItem7 = new AlbumItem(getResources().getString(R.string.album_title_7),
                getResources().getString(R.string.album_description_7),
                getResources().getDrawable(R.drawable.ac_dc_high_voltage),
                getResources().getString(R.string.album_price_7),
                getResources().getString(R.string.album_quantity_7),
                getResources().getString(R.string.album_subtotal_7));

        //Create the eighth album called "Fragile" by Yes.
        AlbumItem albumItem8 = new AlbumItem(getResources().getString(R.string.album_title_8),
                getResources().getString(R.string.album_description_8),
                getResources().getDrawable(R.drawable.yes_fragile),
                getResources().getString(R.string.album_price_8),
                getResources().getString(R.string.album_quantity_8),
                getResources().getString(R.string.album_subtotal_8));

        //Create the ninth album called "Murmur" by R.E.M.
        AlbumItem albumItem9 = new AlbumItem(getResources().getString(R.string.album_title_9),
                getResources().getString(R.string.album_description_9),
                getResources().getDrawable(R.drawable.rem_murmur),
                getResources().getString(R.string.album_price_9),
                getResources().getString(R.string.album_quantity_9),
                getResources().getString(R.string.album_subtotal_9));

        //Create the tenth album called "The Wall" by Pink Floyd.
        AlbumItem albumItem10 = new AlbumItem(getResources().getString(R.string.album_title_10),
                getResources().getString(R.string.album_description_10),
                getResources().getDrawable(R.drawable.pink_floyd_the_wall),
                getResources().getString(R.string.album_price_10),
                getResources().getString(R.string.album_quantity_10),
                getResources().getString(R.string.album_subtotal_10));


        //Add all album items to the data set list.
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

        //Retrieve the instance of the RecyclerView.
        this.mRecyclerView = findViewById(R.id.recyclerView);

        //Create an adapter and supply the data to be displayed.
        this.mAdapter = new ProductAdapter(this, this.mAlbumList);

        //Set the adapter of the RecyclerView.
        this.mRecyclerView.setAdapter(this.mAdapter);

        //Set the LayoutManager of the RecyclerView.
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    /**
     * Stores the data before the activity is being paused.
     *
     * @param savedInstanceState The Bundle values for displaying all data on the device.
     */
    public void onSaveInstanceState(Bundle savedInstanceState) {

        //Launch the method when the activity's data needs to be stored before the state changes..
        super.onSaveInstanceState(savedInstanceState);

        //Create an array list to save the data.
        ArrayList<String> savedAlbumList = new ArrayList<>();

        //For every index of each element in the list of albums, complete the following procedure:
        for (int retrievedElement = 0; retrievedElement < mAlbumList.size(); retrievedElement++) {

            //Add the retrieved quantity and subtotal values to the saved album list.
            savedAlbumList.add(mAlbumList.get(retrievedElement).getAlbumQuantity());
            savedAlbumList.add(mAlbumList.get(retrievedElement).getAlbumSubtotal());

            //Print a log message to ensure onSaveInstanceState method's functionality.
            Log.d("Saved the Quantity and Subtotal from the " + retrievedElement + "th Element.", savedAlbumList.get(retrievedElement));
        }

        //Save the album list when the activity state changes.
        savedInstanceState.putStringArrayList("Album ArrayList", savedAlbumList);
    }


    /**
     * Retrieves the data back when the activity is resumed again.
     *
     * @param savedInstanceState The Bundle values for displaying all data on the device.
     */
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

        //Launch the method when the activity's data needs to be restored after the state changes.
        super.onRestoreInstanceState(savedInstanceState);

        //Create an array list to restore the data.
        ArrayList<String> restoredAlbumList = savedInstanceState.getStringArrayList("Album ArrayList");

        //For every index of each retrieved element and every second setter element in the list of albums, complete the following procedure:
        for (int retrievedElement = 0, setterElement = 0; retrievedElement < mAlbumList.size(); retrievedElement++, setterElement += 2) {

            //When the restored album list is not empty.
            assert restoredAlbumList != null;

            //Get the quantity data from the album list and set the quantity based on the restored album list.
            mAlbumList.get(retrievedElement).setAlbumQuantity(restoredAlbumList.get(setterElement));

            //Print a log message to ensure onRestoreInstanceState method's functionality.
            Log.d("Restored the Quantity from the " + retrievedElement + "th Element.", restoredAlbumList.get(retrievedElement));
        }

        //For every index of each retrieved element and every second setter element in the list of albums, complete the following procedure:
        for (int retrievedElement = 0, setterElement = 1; retrievedElement < mAlbumList.size(); retrievedElement++, setterElement += 2) {

            //Get the subtotal data from the album list and set the subtotal based on the restored album list.
            mAlbumList.get(retrievedElement).setAlbumSubtotal(restoredAlbumList.get(setterElement));

            //Print a log message to ensure onRestoreInstanceState method's functionality.
            Log.d("Restored the Subtotal from the " + retrievedElement + "th Element.", restoredAlbumList.get(retrievedElement));
        }


    }


    /**
     * Initializes the album format contents of the options menu.
     *
     * @param menu The options menu where album format items are placed.
     * @return The boolean value indicating whether the menu has been created.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Determines whether a menu item has been selected.
     *
     * @param item The menu audio format item that was selected.
     * @return The boolean value indicating whether the menu has been processed or not.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //According to the menu item's ID,
        switch (item.getItemId()) {

            //If the MP3 download option has been selected, proceed with the following step.
            case R.id.mp3_download_option: {

                //Display a Toast message which responds to the selection of the MP3 download option.
                Toast.makeText(getApplicationContext(), R.string.action_mp3_option_message, Toast.LENGTH_SHORT).show();
                return true;
            }

            //If the audio CD option has been selected, proceed with the following step.
            case R.id.audio_cd_option: {

                //Display a Toast message which responds to the selection of the audio CD option.
                Toast.makeText(getApplicationContext(), R.string.action_cd_option_message, Toast.LENGTH_SHORT).show();
                return true;
            }

            //If the vinyl record option has been selected, proceed with the following step.
            case R.id.vinyl_record_option: {

                //Display a Toast message which responds to the selection of the very good condition option.
                Toast.makeText(getApplicationContext(), R.string.action_vinyl_option_message, Toast.LENGTH_SHORT).show();
                return true;
            }

            //If the audio cassette option has been selected, proceed with the following step.
            case R.id.audio_cassette_option: {

                //Display a Toast message which responds to the selection of the audio cassette option.
                Toast.makeText(getApplicationContext(), R.string.action_cassette_option_message, Toast.LENGTH_SHORT).show();
                return true;
            }

        }
        return super.onOptionsItemSelected(item);
    }


    /**
     * Launches the CheckoutActivity class and calculates the monetary totals.
     */
    @SuppressLint("DefaultLocale")
    public void launchCheckoutActivity() {

        //Create an intent to start the following activity, which is the CheckoutActivity class.
        Intent checkoutIntent = new Intent(this, CheckoutActivity.class);

        //For every element in the album list, proceed with the following procedure,
        for (int element = 0; element < this.mAlbumList.size(); element++) {

            //Calculate the album subtotal of the element by converting the item's String subtotal to a Double value.
            double albumSubtotal = Double.parseDouble(this.mAlbumList.get(element).getAlbumSubtotal().substring(1));

            //Add the album item's subtotal to the overall album subtotal.
            mTotalAlbumSubtotal += albumSubtotal;
        }

        //Set the MenuActivity class formatted monetary totals as tag names, in order for them to be used in the CheckoutActivity.
        checkoutIntent.putExtra(TOTAL_ALBUM_SUBTOTAL, String.format("$%.2f", mTotalAlbumSubtotal));
        checkoutIntent.putExtra(SHIPPING_TOTAL, String.format("$%.2f", mShippingTotal));

        //Start the CheckoutActivity class.
        startActivity(checkoutIntent);

        //Display a Toast message which responds to the "Proceed to Checkout" positive button.
        String launchingCheckoutMessage = "Here is Your Virtual Receipt!";
        Toast toastButtonMessage = Toast.makeText(this, launchingCheckoutMessage, Toast.LENGTH_SHORT);
        toastButtonMessage.show();

        //Print a log message to ensure launchCheckoutActivity method's functionality.
        Log.d(MENU_LOG_TAG, "Transferred Subtotal and Shipping Total to CheckoutActivity with Clicked Button");
    }

}