package com.example.android.mytour;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by dharm on 07-08-2018.
 */

public class AmaravatiFragment extends Fragment {

    public  AmaravatiFragment(){

    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Create and set rootView to inflate the list within the container
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // Create ArrayList  , using ArrayList for variable size array
        final ArrayList<Place> places = new ArrayList<>();
        // Add values to the ArrayList item
        places.add(new Place(getString(R.string.stupa_title), getString(R.string.stupa_subtitle), getString(R.string.stupa_desc),
                R.drawable.stupa));
        places.add(new Place(getString(R.string.statue_title), getString(R.string.statue_subtitle), getString(R.string.statue_desc),
                R.drawable.statue));
        places.add(new Place(getString(R.string.museum_title), getString(R.string.museum_subtitle), getString(R.string.museum_desc),
                R.drawable.amaravathimuseum));

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
