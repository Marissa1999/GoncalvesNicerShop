package com.example.goncalvesnicershop.model;

import android.graphics.drawable.Drawable;

public class AlbumItem
{

    //The main attributes for all album items in the RecyclerView.
    private String albumTitle;
    private String albumDescription;
    private Drawable albumImage;
    private String albumPrice;
    private String albumQuantity;
    private String albumSubtotal;


    /**
     * The main constructor that initializes the main attributes for all album items.
     * @param albumTitle The title of the album.
     * @param albumDescription The description of the album.
     * @param albumImage The main album cover.
     * @param albumPrice The price of the album.
     * @param albumQuantity The quantity of the album.
     * @param albumSubtotal The subtotal of the album.
     */
    public AlbumItem(String albumTitle, String albumDescription, Drawable albumImage, String albumPrice, String albumQuantity, String albumSubtotal)
    {
        this.albumTitle = albumTitle;
        this.albumDescription = albumDescription;
        this.albumImage = albumImage;
        this.albumPrice = albumPrice;
        this.albumQuantity = albumQuantity;
        this.albumSubtotal = albumSubtotal;
    }


    /**
     * Retrieves the title of the album.
     * @return The title of the album.
     */
    public String getAlbumTitle()
    {
        return albumTitle;
    }

    /**
     * Retrieves the description of the album.
     * @return The description of the album.
     */
    public String getAlbumDescription()
    {
        return albumDescription;
    }

    /**
     * Retrieves the original album cover.
     * @return The original cover of the album.
     */
    public Drawable getAlbumImage()
    {
        return albumImage;
    }


    /**
     * Retrieves the price of the album.
     * @return The price of the album.
     */
    public String getAlbumPrice()
    {
        return albumPrice;
    }

    /**
     * Retrieves the quantity of the album.
     * @return The quantity of the album.
     */
    public String getAlbumQuantity()
    {
        return albumQuantity;
    }

    /**
     * Sets the quantity value of the album.
     * @param albumQuantity The quantity of the album.
     */
    public void setAlbumQuantity(String albumQuantity)
    {
        this.albumQuantity = albumQuantity;
    }

    /**
     * Retrieves the subtotal of the album.
     * @return The subtotal of the album.
     */
    public String getAlbumSubtotal()
    {
        return albumSubtotal;
    }

    /**
     * Sets the subtotal value of the album.
     * @param albumSubtotal The subtotal of the album.
     */
    public void setAlbumSubtotal(String albumSubtotal)
    {
        this.albumSubtotal = albumSubtotal;
    }
}
