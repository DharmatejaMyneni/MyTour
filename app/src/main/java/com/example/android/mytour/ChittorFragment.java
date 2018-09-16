package com.example.android.mytour;

/**
 * Created by dharm on 07-08-2018.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ChittorFragment extends Fragment {

    public ChittorFragment(){


    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Create and set rootView to inflate the list within the container
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // Create ArrayList  , using ArrayList for variable size array
        final ArrayList<Place> places = new ArrayList<>();
        // Add values to the ArrayList item
        //  information from Wikipedia as of 7/2018
        places.add(new Place(getString(R.string.tirumala_title), getString(R.string.tirumala_subtitle), getString(R.string.tirumala_desc),
                R.drawable.tirumala));
        places.add(new Place(getString(R.string.tirumalaPark_title), getString(R.string.tirumlaPark_subtitle), getString(R.string.tirumalaPark_desc),
                R.drawable.tirumala_zoo));
        places.add(new Place(getString(R.string.fort_title), getString(R.string.fort_subtitle), getString(R.string.fort_desc),
                R.drawable.fort));

        //initialize itemsAdapter using places ArrayList
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);
        //Initialize listView as the list View from the applicable xml file
        ListView listView = rootView.findViewById(R.id.list);
        //set the adapter for listView (which is "list" view in the applicable xml) to itemsView using places
        listView.setAdapter(adapter);


        /**
         *  Set on item click listener block
         *  Creates Variable of clicked item, assigns intent values and starts activity
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //Creating a Class variable to hold the destination activity depending on Switch below
                Class myActivityToIntent = PlaceInfoViewer.class;

                // Create a new intent to open the {@link applicable activity}
                Intent myIntent = new Intent(getActivity().getApplicationContext(), myActivityToIntent);

                //Assign values based on position in ListView, hardcoded based on ArrayList addition order
                myIntent.putExtra(getString(R.string.myTitle), places.get(i).getPlaceTitle());
                myIntent.putExtra(getString(R.string.mySubTitle), places.get(i).getPlaceSubtitle());
                myIntent.putExtra(getString(R.string.myDesc), places.get(i).getPlaceDesc());
                myIntent.putExtra(getString(R.string.myImg), places.get(i).getItemImage());

                // Start the new activity
                startActivity(myIntent);

            }
        }); // END setOnItemClickListener

        // Inflate the layout for this fragment
        return rootView;
    } // End OnCreateView
}
