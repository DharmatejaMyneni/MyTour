package com.example.android.mytour;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by dharm on 07-08-2018.
 */

public class PlaceInfoViewer extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Setting the content view to the matching XML file created
        setContentView(R.layout.activity_place_info);

        String newString;
        String newStringForSub;
        String newStringforDesc;
        int newImg = 0;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                newString = null;
                newStringForSub = null;
                newStringforDesc = null;
            } else {
                newString = extras.getString(getString(R.string.myTitle));
                newStringForSub = extras.getString(getString(R.string.mySubTitle));
                newStringforDesc = extras.getString(getString(R.string.myDesc));
                newImg = extras.getInt(getString(R.string.myImg)); //note: this value is an int
            }
        } else {
            newString = (String) savedInstanceState.getSerializable(getString(R.string.string_i_need));
            newStringForSub = (String) savedInstanceState.getSerializable(getString(R.string.string_i_need));
            newStringforDesc = (String) savedInstanceState.getSerializable(getString(R.string.string_i_need));
        }

        // places ArrayList initialize, using ArrayList for variable size array
        ArrayList<Place> places = new ArrayList<>();

        //Add values to the ArrayList Tune for each
        places.add(new Place(newString, newStringForSub, newStringforDesc, newImg));

        //initialize itemsAdapter using places ArrayList
        PlaceViewerAdapter itemsAdapter = new PlaceViewerAdapter(this, places);

        //Initialize listView as the list View from the applicable xml file
        ListView mylistView = findViewById(R.id.place_info);

        //set the adapter for listView (which is "list" view in the applicable xml) to itemsView using places
        mylistView.setAdapter(itemsAdapter);

    }

}
