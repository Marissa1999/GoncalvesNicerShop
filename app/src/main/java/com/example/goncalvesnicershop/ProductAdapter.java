package com.example.goncalvesnicershop;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
         String current = String.valueOf(this.albumList.get(position));
         holder.albumItemView.setText(current);
    }



    @Override
    public int getItemCount()
    {
        return this.albumList.size();
    }




    public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        public final TextView albumItemView;
        public final ProductAdapter adapter;


        public ProductViewHolder(@NonNull View albumItemView, ProductAdapter adapter)
        {
            super(albumItemView);
            this.albumItemView = albumItemView.findViewById(R.id.album_content);
            this.adapter = adapter;
            itemView.setOnClickListener(this);
        }



        @Override
        public void onClick(View view)
        {



        }
    }
}
