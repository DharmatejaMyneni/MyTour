package com.example.android.mytour;

/**
 * Created by dharm on 07-08-2018.
 */

public class Place {
    private String placeTitle;
    private String placeSubtitle;
    private String descInfo;
    private int imageResourceID = -1;

    //constructor with two elemnets
    public Place(String firstTextInput, String SecondTextInput) {
        placeTitle = firstTextInput;
        placeSubtitle = SecondTextInput;
    }

    //constructor with THREE elemnets
    public Place(String firstTextInput, String SecondTextInput, int itemImageInput) {
        placeTitle = firstTextInput;
        placeSubtitle = SecondTextInput;
        imageResourceID = itemImageInput;
    }

    //constructor with FOUR elemnets
    public Place(String firstTextInput, String SecondTextInput, String ThirdTextInput, int itemImageInput) {
        placeTitle = firstTextInput;
        placeSubtitle = SecondTextInput;
        descInfo = ThirdTextInput;
        imageResourceID = itemImageInput;
    }

    //Sets the first Place
    public void setPlaceTitle(String firstTextInput) {
        placeTitle = firstTextInput;
    }

    //Sets the second Place
    public void setWord(String SecondTextInput) {
        placeSubtitle = SecondTextInput;
    }

    //Sets the second Place
    public void setDesc (String ThirdTextInput) {
        descInfo = ThirdTextInput;
    }

    //sets the image
    public void setItemImage(int itemImageInput) {
        imageResourceID = itemImageInput;
    }

    //Gets the first Place
    public String getPlaceTitle() {
        return placeTitle;
    }

    //Gets the second word
    public String getPlaceSubtitle() {
        return placeSubtitle;
    }

    //Gets the second word
    public String getPlaceDesc() {        return descInfo;    }

    //get image
    public int getItemImage() {
        return imageResourceID;
    }

    //Checks if a resource has been assigned to the variable
    public boolean hasImage() {
        return imageResourceID != -1;
    }


}

