package com.example.goncalvesnicershop.model;

import android.graphics.drawable.Drawable;

public class AlbumItem
{

    private String albumTitle;
    private String albumDescription;
    private Drawable albumImage;
    private String albumPrice;
    private String albumQuantity;


    public AlbumItem(String albumTitle, String albumDescription, Drawable albumImage, String albumPrice, String albumQuantity)
    {
        this.albumTitle = albumTitle;
        this.albumDescription = albumDescription;
        this.albumImage = albumImage;
        this.albumPrice = albumPrice;
        this.albumQuantity = albumQuantity;
    }


    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public String getAlbumDescription() {
        return albumDescription;
    }

    public void setAlbumDescription(String albumDescription) {
        this.albumDescription = albumDescription;
    }

    public Drawable getAlbumImage() {
        return albumImage;
    }

    public void setAlbumImage(Drawable albumImage) {
        this.albumImage = albumImage;
    }

    public String getAlbumPrice() {
        return albumPrice;
    }

    public void setAlbumPrice(String albumPrice) {
        this.albumPrice = albumPrice;
    }

    public String getAlbumQuantity() {
        return albumQuantity;
    }

    public void setAlbumQuantity(String albumQuantity) {
        this.albumQuantity = albumQuantity;
    }


}
