package com.example.android.mytour;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by dharm on 07-08-2018.
 */

    class PlaceViewerAdapter extends ArrayAdapter<Place> {


        private int viewBGColor;


        public PlaceViewerAdapter(Activity context, ArrayList<Place> Tunes) {
            super(context, 0, Tunes);
            viewBGColor = R.color.white_background;
        }

        /**
         * Provides a view for an AdapterView (ListView, GridView, etc.)
         * * @param position    The position in the list of data that should be displayed in the
         * list item view.
         *
         * @param convertView The recycled view to populate.
         * @param parent      The parent ViewGroup that is used for inflation.
         * @return The View for the position in the AdapterView.
         */
        @NonNull
        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent) {
            // Check if the existing view is being reused, otherwise inflate the view
            View listItemView = convertView;

            if (listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.place_info_list_item, parent, false);
            }

            // Get the {@link Tune} object located at this position in the list
            Place currentPlace = getItem(position);

        /*  Title Tune ***********************************/
            // Find the TextView in the list_item.xml layout with the ID version_name
            TextView titleTextView = listItemView.findViewById(R.id.listItemName);
            // Get the version name from the current Tune object and set this text on the name TextView
            titleTextView.setText(currentPlace.getPlaceTitle());


        /* SUB Title Tune ***********************************/
            // Find the TextView in the list_item.xml layout with the ID version_number
            TextView subtitleTextView = listItemView.findViewById(R.id.listItemDesc);
            // Get the version number from the current Tune object and set this text on the number TextView
            subtitleTextView.setText(currentPlace.getPlaceDesc());

        /* IMAGE FOR ITEM ***********************************/
            // Find the imageview in list_item.xml
            ImageView myImageView = listItemView.findViewById(R.id.myImage);
            if (currentPlace.hasImage()) {
                // Get the image resource and set it to the image view
                myImageView.setImageResource(currentPlace.getItemImage());
            } else {
                //if there is no valid image ID
                myImageView.setVisibility(View.GONE);
            }

            //background
            View textContainer = listItemView.findViewById(R.id.place_info_card_view);
            //find the value of the color through below single line
            int color = ContextCompat.getColor(getContext(), viewBGColor);
            textContainer.setBackgroundColor(color);

            // Return the whole list item layout (containing 2 TextViews and an ImageView)
            // so that it can be shown in the ListView
            return listItemView;
        }

}
