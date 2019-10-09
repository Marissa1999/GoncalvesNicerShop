package com.example.goncalvesnicershop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.goncalvesnicershop.model.AlbumItem;
import java.util.LinkedList;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private final LinkedList<AlbumItem> albumList;
    private final LayoutInflater albumInflater;
    private static final String ADAPTER_LOG_TAG = ProductAdapter.class.getSimpleName();
    protected static final String FINAL_SUBTOTAL = "com.example.android.goncalvesnicershop.extra.MESSAGE";
    protected static final String TPS_TAX = "com.example.android.goncalvesnicershop.tps.TAX";
    protected static final String TVQ_TAX = "com.example.android.goncalvesnicershop.tvq.TAX";
    protected static final String FINAL_TOTAL = "com.example.android.goncalvesnicershop.final.TOTAL";


    ProductAdapter(Context context, LinkedList<AlbumItem> albumList) {
        this.albumList = albumList;
        this.albumInflater = LayoutInflater.from(context);
    }



    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View albumItemView = albumInflater.inflate(R.layout.album_content, parent, false);
        return new ProductViewHolder(albumItemView, this);
    }


    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position)
    {
        holder.albumTitle.setText(albumList.get(position).getAlbumTitle());
        holder.albumDescription.setText(albumList.get(position).getAlbumDescription());
        holder.albumImage.setImageDrawable(albumList.get(position).getAlbumImage());
        holder.albumPrice.setText(albumList.get(position).getAlbumPrice());
        holder.albumQuantity.setText(albumList.get(position).getAlbumQuantity());
        holder.albumSubtotal.setText(albumList.get(position).getAlbumSubtotal());
    }


    @Override
    public int getItemCount() {
        return this.albumList.size();
    }


    public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final ProductAdapter adapter;
        private final CardView album;
        private final TextView albumTitle;
        private final TextView albumDescription;
        private final ImageView albumImage;
        private final TextView albumPrice;
        private final TextView albumQuantity;
        private final TextView albumSubtotal;
        private int updatedQuantity;

        private final String MENU_LOG_TAG = MenuActivity.class.getSimpleName();

        private double finalSubtotal = 0.00;
        private double totalTPSTax = 0.00;
        private double totalTVQTax = 0.00;
        private double finalTotal = 0.00;


        ProductViewHolder(@NonNull View albumItemView, ProductAdapter adapter) {
            super(albumItemView);
            this.album = albumItemView.findViewById(R.id.album_content);
            this.albumTitle = albumItemView.findViewById(R.id.album_title);
            this.albumDescription = albumItemView.findViewById(R.id.album_description);
            this.albumImage = albumItemView.findViewById(R.id.album_cover);
            this.albumPrice = albumItemView.findViewById(R.id.album_price);
            this.albumQuantity = albumItemView.findViewById(R.id.album_quantity);
            this.albumSubtotal = albumItemView.findViewById(R.id.album_subtotal);
            this.adapter = adapter;
            albumItemView.setOnClickListener(this);
        }


        @SuppressLint("SetTextI18n")
        @Override
        public void onClick(View view) {

            switch (view.getId()) {

                case R.id.adding_button: {

                    this.updatedQuantity++;

                    //If the first album quantity is less than 0, the quantity should remain at 0
                    if (this.updatedQuantity < 0) {
                        this.updatedQuantity = 0;
                    }

                    //Convert the first album quantity Integer value to a String value and set it to the TextView first album quantity element
                    if (this.albumQuantity != null)
                        this.albumQuantity.setText(Integer.toString(this.updatedQuantity));

                    //Print a log message to ensure addAlbumQuantity1 method's functionality
                    Log.d(MENU_LOG_TAG, "Added Quantity to Album");

                    //Call this method to calculate the first album's subtotal according to implemented arguments
                    showAlbumSubtotal(this.updatedQuantity, this.albumPrice, this.albumSubtotal, view);
                }


                case R.id.minus_button: {

                    this.updatedQuantity--;

                    //If the first album quantity is less than 0, the quantity should remain at 0
                    if (this.updatedQuantity < 0) {
                        this.updatedQuantity = 0;
                    }

                    //Convert the first album quantity Integer value to a String value and set it to the TextView first album quantity element
                    if (this.albumQuantity != null)
                        this.albumQuantity.setText(Integer.toString(this.updatedQuantity));

                    //Print a log message to ensure addAlbumQuantity1 method's functionality
                    Log.d(MENU_LOG_TAG, "Subtracted Quantity to Album");

                    //Call this method to calculate the first album's subtotal according to implemented arguments
                    showAlbumSubtotal(this.updatedQuantity, this.albumPrice, this.albumSubtotal, view);

                }

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

            sendMonetaryTotals(view);
        }


        /*
          Calculate the final subtotal instance variable
        */
        void calculateAlbumFinalSubtotal(double albumSubtotal) {

            //Determine the final subtotal value by adding the CardView album subtotal to the variable
            this.finalSubtotal += albumSubtotal;

            //Print a log message to ensure calculateAlbumFinalSubtotal method's functionality
            Log.d(MENU_LOG_TAG, "Calculated Album Final Subtotal");
        }


        /*
          Calculate the instance variable values for both Canadian taxes
        */
        void calculateAlbumFinalTotalTaxes() {

            //Determine the final subtotal value by adding the CardView album subtotal to the variable
            this.totalTPSTax = this.finalSubtotal * 0.05;
            this.totalTVQTax = this.finalSubtotal * 0.0975;

            //Print a log message to ensure calculateAlbumFinalTotalTaxes method's functionality
            Log.d(MENU_LOG_TAG, "Calculated Album Final Subtotal Taxes");
        }


        /*
          Calculate the final subtotal instance variable
        */
        void calculateAlbumFinalTotal() {

            //Determine the final total value by adding the album subtotal and tax totals together
            this.finalTotal = this.finalSubtotal + this.totalTPSTax + this.totalTVQTax;

            //Print a log message to ensure calculateAlbumFinalTotal method's functionality
            Log.d(MENU_LOG_TAG, "Calculated Album Final Total");
        }


        /*
     Launch the CheckoutActivity class, which is supposed to be the following activity
    */
        @SuppressLint("DefaultLocale")
        void sendMonetaryTotals(View view)
        {

            //Create an intent to start the following activity, which is MenuActivity
            Intent menuIntent = new Intent(this, MenuActivity.class);

            //Set the MenuActivity class formatted monetary values as tag names, in order for them to be used in the CheckoutActivity
            //These Double instance variables hold values for final purchase totals
            menuIntent.putExtra(FINAL_SUBTOTAL, String.format("$%.2f", this.finalSubtotal));
            menuIntent.putExtra(TPS_TAX, String.format("$%.2f", this.totalTPSTax));
            menuIntent.putExtra(TVQ_TAX, String.format("$%.2f", this.totalTVQTax));
            menuIntent.putExtra(FINAL_TOTAL, String.format("$%.2f", this.finalTotal));

            startActivity(menuIntent);


            //Print a log message to ensure launchCheckoutActivity method's functionality
            Log.d(ADAPTER_LOG_TAG, "Transferred Subtotal, Tax Values and Final Total to CheckoutActivity with Clicked Button");
        }
    }


}
