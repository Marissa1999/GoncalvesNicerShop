package com.example.goncalvesnicershop.model;

import android.graphics.drawable.Drawable;
import android.util.Log;

public class AlbumItem {

    //The tag to call the AlbumItem class name when debugging code.
    private static final String ALBUM_ITEM_TAG = AlbumItem.class.getSimpleName();

    //The member attributes for all album items in the RecyclerView.
    private String mAlbumTitle;
    private String mAlbumDescription;
    private Drawable mAlbumImage;
    private String mAlbumPrice;
    private String mAlbumQuantity;
    private String mAlbumSubtotal;


    /**
     * Initializes the main attributes for all album items.
     *
     * @param albumTitle       The title of the album.
     * @param albumDescription The description of the album.
     * @param albumImage       The main album cover.
     * @param albumPrice       The price of the album.
     * @param albumQuantity    The quantity of the album.
     * @param albumSubtotal    The subtotal of the album.
     */
    public AlbumItem(String albumTitle, String albumDescription, Drawable albumImage, String albumPrice, String albumQuantity, String albumSubtotal) {
        this.mAlbumTitle = albumTitle;
        this.mAlbumDescription = albumDescription;
        this.mAlbumImage = albumImage;
        this.mAlbumPrice = albumPrice;
        this.mAlbumQuantity = albumQuantity;
        this.mAlbumSubtotal = albumSubtotal;

        //
        Log.d(ALBUM_ITEM_TAG, "Initialized All Attributes for Each Album Item.");
    }


    /**
     * Retrieves the title of the album.
     *
     * @return The title of the album.
     */
    public String getAlbumTitle() {
        Log.d(ALBUM_ITEM_TAG, "Retrieved the Title of the Album.");
        return this.mAlbumTitle;
    }

    /**
     * Retrieves the description of the album.
     *
     * @return The description of the album.
     */
    public String getAlbumDescription() {
        Log.d(ALBUM_ITEM_TAG, "Retrieved the Description of the Album.");
        return this.mAlbumDescription;
    }

    /**
     * Retrieves the original album cover image.
     *
     * @return The cover image of the album.
     */
    public Drawable getAlbumImage() {
        Log.d(ALBUM_ITEM_TAG, "Retrieved the Album Cover Image.");
        return this.mAlbumImage;
    }

    /**
     * Retrieves the price of the album.
     *
     * @return The price of the album.
     */
    public String getAlbumPrice() {
        Log.d(ALBUM_ITEM_TAG, "Retrieved the Price of the Album.");
        return this.mAlbumPrice;
    }

    /**
     * Retrieves the quantity of the album.
     *
     * @return The quantity of the album.
     */
    public String getAlbumQuantity() {
        Log.d(ALBUM_ITEM_TAG, "Retrieved the Quantity of the Album.");
        return this.mAlbumQuantity;
    }

    /**
     * Sets the quantity value of the album.
     *
     * @param albumQuantity The quantity of the album.
     */
    public void setAlbumQuantity(String albumQuantity) {
        Log.d(ALBUM_ITEM_TAG, "Initialized the Quantity of the Album.");
        this.mAlbumQuantity = albumQuantity;
    }

    /**
     * Retrieves the subtotal of the album.
     *
     * @return The subtotal of the album.
     */
    public String getAlbumSubtotal() {
        Log.d(ALBUM_ITEM_TAG, "Retrieved the Subtotal of the Album.");
        return this.mAlbumSubtotal;
    }

    /**
     * Sets the subtotal value of the album.
     *
     * @param albumSubtotal The subtotal of the album.
     */
    public void setAlbumSubtotal(String albumSubtotal) {
        Log.d(ALBUM_ITEM_TAG, "Initialized the Subtotal of the Album.");
        this.mAlbumSubtotal = albumSubtotal;
    }
}
