package com.example.goncalvesnicershop;

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


    public ProductAdapter(LinkedList<AlbumItem> albumList, LayoutInflater albumInflater)
    {
        this.albumList = albumList;
        this.albumInflater = albumInflater;
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return null;
    }



    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int i)
    {

    }



    @Override
    public int getItemCount()
    {
        return 0;
    }




    public class ProductViewHolder extends RecyclerView.ViewHolder
    {

        public final TextView albumItemView;
        public final ProductAdapter adapter;


        public ProductViewHolder(@NonNull View itemView, TextView albumItemView, ProductAdapter adapter)
        {
            super(itemView);
            this.albumItemView = albumItemView;
            this.adapter = adapter;
        }


    }
}
