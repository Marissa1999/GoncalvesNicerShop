package com.example.goncalvesnicershop;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.goncalvesnicershop.model.AlbumItem;

import java.util.LinkedList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>
{

    private final LinkedList<AlbumItem> albumList;
    private final LayoutInflater albumInflater;


    public ProductAdapter(Context context, LinkedList<AlbumItem> albumList)
    {
        this.albumList = albumList;
        this.albumInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
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
    }



    @Override
    public int getItemCount()
    {
        return this.albumList.size();
    }




    public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        public final ProductAdapter adapter;
        public final CardView album;
        public final TextView albumTitle;
        public final TextView albumDescription;
        public final ImageView albumImage;
        public final TextView albumPrice;
        public final TextView albumQuantity;



        public ProductViewHolder(@NonNull View albumItemView, ProductAdapter adapter)
        {
            super(albumItemView);
            this.album = albumItemView.findViewById(R.id.album_content);
            this.albumTitle = albumItemView.findViewById(R.id.album_title);
            this.albumDescription = albumItemView.findViewById(R.id.album_description);
            this.albumImage = albumItemView.findViewById(R.id.album_cover);
            this.albumPrice = albumItemView.findViewById(R.id.album_price);
            this.albumQuantity = albumItemView.findViewById(R.id.album_quantity);
            this.adapter = adapter;
            itemView.setOnClickListener(this);
        }



        @Override
        public void onClick(View view)
        {



        }
    }
}
