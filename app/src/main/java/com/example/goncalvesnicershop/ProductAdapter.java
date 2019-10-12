package com.example.goncalvesnicershop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.goncalvesnicershop.model.AlbumItem;

import java.util.LinkedList;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    //The tag to call the ProductAdapter class name when debugging code.
    private static final String ADAPTER_LOG_TAG = ProductAdapter.class.getSimpleName();

    //These member attributes host the data in the ProductAdapter class.
    private LinkedList<AlbumItem> mAlbumList;
    private LayoutInflater mAlbumInflater;

    /**
     * Receives a context and a list of albums.
     * @param context The context of the album content layout file.
     * @param albumList The album list to set the member attributes for each card.
     */
    ProductAdapter(Context context, LinkedList<AlbumItem> albumList) {
        this.mAlbumList = albumList;
        this.mAlbumInflater = LayoutInflater.from(context);
    }

    /**
     * Inflates the item layout and returns a ProductViewHolder object.
     * @param parent The ViewGroup which the new View element will be added after finding its position.
     * @param viewType The view type of the new View element.
     * @return The ProductViewHolder that holds the View based on the view type.
     */
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View albumItemView = mAlbumInflater.inflate(R.layout.album_content, parent, false);
        return new ProductViewHolder(albumItemView, this);
    }

    /**
     * Sets the ProductViewHolder attributes based on the position of the item.
     * @param holder The ProductViewHolder being updated to determine the contents at a position.
     * @param position The position of the album item in the ProductAdapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.mAlbumTitle.setText(mAlbumList.get(position).getAlbumTitle());
        holder.mAlbumDescription.setText(mAlbumList.get(position).getAlbumDescription());
        holder.mAlbumImage.setImageDrawable(mAlbumList.get(position).getAlbumImage());
        holder.mAlbumPrice.setText(mAlbumList.get(position).getAlbumPrice());
        holder.mAlbumQuantity.setText(mAlbumList.get(position).getAlbumQuantity());
        holder.mAlbumSubtotal.setText(mAlbumList.get(position).getAlbumSubtotal());
    }

    /**
     * Returns the size of the data.
     * @return The size of the album list.
     */
    @Override
    public int getItemCount() {
        return this.mAlbumList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        //These member attributes initialize the variables of the ProductViewHolder for the ProductAdapter.
        ProductAdapter mAdapter;
        CardView mAlbum;
        private TextView mAlbumTitle;
        private TextView mAlbumDescription;
        private ImageView mAlbumImage;
        private TextView mAlbumPrice;
        private TextView mAlbumQuantity;
        private TextView mAlbumSubtotal;
        private Button mAdditionButton;
        private Button mSubtractionButton;

        /**
         * Initializes the ProductViewHolder based on the view of the item as a parameter.
         * @param albumItemView The View of the specific album item.
         * @param adapter The ProductAdapter that holds all the contents of the album in place.
         */
        ProductViewHolder(@NonNull View albumItemView, ProductAdapter adapter) {
            super(albumItemView);
            this.mAlbum = albumItemView.findViewById(R.id.album_content);
            this.mAlbumTitle = albumItemView.findViewById(R.id.album_title);
            this.mAlbumDescription = albumItemView.findViewById(R.id.album_description);
            this.mAlbumImage = albumItemView.findViewById(R.id.album_cover);
            this.mAlbumPrice = albumItemView.findViewById(R.id.album_price);
            this.mAlbumQuantity = albumItemView.findViewById(R.id.album_quantity);
            this.mAlbumSubtotal = albumItemView.findViewById(R.id.album_subtotal);
            this.mAdditionButton = albumItemView.findViewById(R.id.adding_button);
            this.mSubtractionButton = albumItemView.findViewById(R.id.minus_button);
            this.mAdapter = adapter;
            this.mAdditionButton.setOnClickListener(this);
            this.mSubtractionButton.setOnClickListener(this);
            albumItemView.setOnClickListener(this);
        }

        /**
         * Identifies actions based on the button that was clicked.
         * @param view The View of the specific button.
         */
        @SuppressLint({"SetTextI18n", "DefaultLocale"})
        @Override
        public void onClick(View view) {

            switch (view.getId()) {

                case R.id.adding_button: {
                    int position = getLayoutPosition();
                    AlbumItem product = mAlbumList.get(position);
                    int updatedAddedQuantity = Integer.parseInt(product.getAlbumQuantity()) + 1;
                    product.setAlbumQuantity(String.valueOf(updatedAddedQuantity));

                    String printedPrice = product.getAlbumPrice().substring(1);
                    double addedPrice = Double.parseDouble(printedPrice);

                    double addedSubtotal = addedPrice * updatedAddedQuantity;
                    product.setAlbumSubtotal(String.format("$%.2f", addedSubtotal));

                    if (this.mAlbumQuantity != null)
                        this.mAlbumQuantity.setText(String.valueOf(updatedAddedQuantity));

                    if (this.mAlbumSubtotal != null)
                        this.mAlbumSubtotal.setText(String.format("$%.2f", addedSubtotal));

                    Log.d(ADAPTER_LOG_TAG, "Added " + product.getAlbumQuantity() + " " + product.getAlbumTitle() + " Album(s)");
                }
                break;


                case R.id.minus_button: {
                    int position = getLayoutPosition();
                    AlbumItem product = mAlbumList.get(position);
                    int updatedSubtractedQuantity = Integer.parseInt(product.getAlbumQuantity()) - 1;
                    product.setAlbumQuantity(String.valueOf(updatedSubtractedQuantity));

                    if (updatedSubtractedQuantity < 0) {
                        updatedSubtractedQuantity = 0;
                        product.setAlbumQuantity(String.valueOf(updatedSubtractedQuantity));
                    }

                    String printedPrice = product.getAlbumPrice().substring(1);
                    double subtractedPrice = Double.parseDouble(printedPrice);

                    double subtractedSubtotal = subtractedPrice * updatedSubtractedQuantity;
                    product.setAlbumSubtotal(String.format("$%.2f", subtractedSubtotal));

                    if (this.mAlbumQuantity != null)
                        this.mAlbumQuantity.setText(String.valueOf(updatedSubtractedQuantity));

                    if (this.mAlbumSubtotal != null)
                        this.mAlbumSubtotal.setText(String.format("$%.2f", subtractedSubtotal));

                    Log.d(ADAPTER_LOG_TAG, "Subtracted " + product.getAlbumQuantity() + " " + product.getAlbumTitle() + " Album(s)");
                }
                break;

            }


        }
    }


}
