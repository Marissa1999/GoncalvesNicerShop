package com.example.goncalvesnicershop.model;

import android.graphics.drawable.Drawable;

public class AlbumItem1
{

    private String albumTitle_1;
    private String albumDescription_1;
    private Drawable albumImage_1;
    private String albumPrice_1;
    private String albumQuantity_1;


    public AlbumItem1(String albumTitle_1, String albumDescription_1,
                      Drawable albumImage_1, String albumPrice_1,
                      String albumQuantity_1)
    {
        this.albumTitle_1 = albumTitle_1;
        this.albumDescription_1 = albumDescription_1;
        this.albumImage_1 = albumImage_1;
        this.albumPrice_1 = albumPrice_1;
        this.albumQuantity_1 = albumQuantity_1;
    }

    public String getAlbumTitle_1()
    {
        return albumTitle_1;
    }

    public void setAlbumTitle_1(String albumTitle_1)
    {
        this.albumTitle_1 = albumTitle_1;
    }

    public String getAlbumDescription_1()
    {
        return albumDescription_1;
    }

    public void setAlbumDescription_1(String albumDescription_1)
    {
        this.albumDescription_1 = albumDescription_1;
    }

    public Drawable getAlbumImage_1()
    {
        return albumImage_1;
    }

    public void setAlbumImage_1(Drawable albumImage_1)
    {
        this.albumImage_1 = albumImage_1;
    }

    public String getAlbumPrice_1()
    {
        return albumPrice_1;
    }

    public void setAlbumPrice_1(String albumPrice_1)
    {
        this.albumPrice_1 = albumPrice_1;
    }

    public String getAlbumQuantity_1()
    {
        return albumQuantity_1;
    }

    public void setAlbumQuantity_1(String albumQuantity_1)
    {
        this.albumQuantity_1 = albumQuantity_1;
    }




}
