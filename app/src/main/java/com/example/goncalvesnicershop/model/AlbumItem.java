package com.example.goncalvesnicershop.model;

import android.graphics.drawable.Drawable;
import android.util.Log;

public class AlbumItem {

    //The tag to call the AlbumItem class name when debugging code.
    private static final String ALBUM_ITEM_TAG = AlbumItem.class.getSimpleName();

    //The main attributes for all album items in the RecyclerView.
    private String albumTitle;
    private String albumDescription;
    private Drawable albumImage;
    private String albumPrice;
    private String albumQuantity;
    private String albumSubtotal;


    /**
     * The main constructor that initializes the main attributes for all album items.
     *
     * @param albumTitle       The title of the album.
     * @param albumDescription The description of the album.
     * @param albumImage       The main album cover.
     * @param albumPrice       The price of the album.
     * @param albumQuantity    The quantity of the album.
     * @param albumSubtotal    The subtotal of the album.
     */
    public AlbumItem(String albumTitle, String albumDescription, Drawable albumImage, String albumPrice, String albumQuantity, String albumSubtotal) {
        this.albumTitle = albumTitle;
        this.albumDescription = albumDescription;
        this.albumImage = albumImage;
        this.albumPrice = albumPrice;
        this.albumQuantity = albumQuantity;
        this.albumSubtotal = albumSubtotal;
    }


    /**
     * Retrieves the title of the album.
     *
     * @return The title of the album.
     */
    public String getAlbumTitle() {
        Log.d(ALBUM_ITEM_TAG, "Retrieved the title of the album.");
        return albumTitle;
    }

    /**
     * Retrieves the description of the album.
     *
     * @return The description of the album.
     */
    public String getAlbumDescription() {
        Log.d(ALBUM_ITEM_TAG, "Retrieved the description of the album.");
        return albumDescription;
    }

    /**
     * Retrieves the original album cover image.
     *
     * @return The cover image of the album.
     */
    public Drawable getAlbumImage() {
        Log.d(ALBUM_ITEM_TAG, "Retrieved the album cover image.");
        return albumImage;
    }

    /**
     * Retrieves the price of the album.
     *
     * @return The price of the album.
     */
    public String getAlbumPrice() {
        Log.d(ALBUM_ITEM_TAG, "Retrieved the price of the album.");
        return albumPrice;
    }

    /**
     * Retrieves the quantity of the album.
     *
     * @return The quantity of the album.
     */
    public String getAlbumQuantity() {
        Log.d(ALBUM_ITEM_TAG, "Retrieved the quantity of the album.");
        return albumQuantity;
    }

    /**
     * Sets the quantity value of the album.
     *
     * @param albumQuantity The quantity of the album.
     */
    public void setAlbumQuantity(String albumQuantity) {
        Log.d(ALBUM_ITEM_TAG, "Initialized the quantity of the album.");
        this.albumQuantity = albumQuantity;
    }

    /**
     * Retrieves the subtotal of the album.
     *
     * @return The subtotal of the album.
     */
    public String getAlbumSubtotal() {
        Log.d(ALBUM_ITEM_TAG, "Retrieved the subtotal of the album.");
        return albumSubtotal;
    }

    /**
     * Sets the subtotal value of the album.
     *
     * @param albumSubtotal The subtotal of the album.
     */
    public void setAlbumSubtotal(String albumSubtotal) {
        Log.d(ALBUM_ITEM_TAG, "Initialized the subtotal of the album.");
        this.albumSubtotal = albumSubtotal;
    }
}
