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

    private final LinkedList<AlbumItem> albumList;
    private final LayoutInflater albumInflater;

    private static final String ADAPTER_LOG_TAG = ProductAdapter.class.getSimpleName();


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


        private ProductAdapter adapter;
        private CardView album;
        private TextView albumTitle;
        private TextView albumDescription;
        private ImageView albumImage;
        private TextView albumPrice;
        private TextView albumQuantity;
        private TextView albumSubtotal;
        private Button additionButton;
        private Button subtractionButton;



        ProductViewHolder(@NonNull View albumItemView, ProductAdapter adapter) {
            super(albumItemView);
            this.album = albumItemView.findViewById(R.id.album_content);
            this.albumTitle = albumItemView.findViewById(R.id.album_title);
            this.albumDescription = albumItemView.findViewById(R.id.album_description);
            this.albumImage = albumItemView.findViewById(R.id.album_cover);
            this.albumPrice = albumItemView.findViewById(R.id.album_price);
            this.albumQuantity = albumItemView.findViewById(R.id.album_quantity);
            this.albumSubtotal = albumItemView.findViewById(R.id.album_subtotal);
            this.additionButton = albumItemView.findViewById(R.id.adding_button);
            this.subtractionButton = albumItemView.findViewById(R.id.minus_button);
            this.adapter = adapter;
            this.additionButton.setOnClickListener(this);
            this.subtractionButton.setOnClickListener(this);
        }


        @SuppressLint("SetTextI18n")
        @Override
        public void onClick(View view) {

            switch (view.getId()) {

                case R.id.adding_button:
                {
                     int position = (Integer) view.getTag();
                     AlbumItem product = albumList.get(position);
                     int updatedAddedQuantity = product.getAlbumQuantity() + 1;
                     product.setAlbumQuantity(updatedAddedQuantity);
                     notifyDataSetChanged();
                     this.albumQuantity.setText(updatedAddedQuantity);

                    Log.d(ADAPTER_LOG_TAG, "Added " + product.getAlbumQuantity() + product.getAlbumTitle() + " Albums");
                }
                break;


                case R.id.minus_button:
                {
                    int position = (Integer) view.getTag();
                    AlbumItem product = albumList.get(position);
                    int updatedSubtractedQuantity = product.getAlbumQuantity() - 1;
                    product.setAlbumQuantity(updatedSubtractedQuantity);
                    notifyDataSetChanged();
                    this.albumQuantity.setText(updatedSubtractedQuantity);

                    Log.d(ADAPTER_LOG_TAG, "Subtracted " + product.getAlbumQuantity() + " " + product.getAlbumTitle() + " Albums");
                }
                break;

            }


        }
    }




}
