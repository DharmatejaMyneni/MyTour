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

public class PlaceAdapter extends ArrayAdapter<Place> {

    private int viewBGColor;

    public PlaceAdapter(Activity context, ArrayList<Place> places) {
        super(context, 0, places);
        viewBGColor = R.color.white_background;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Place} object located at this position in the list
        Place currentPlace = getItem(position);

        /*  first place ***********************************/
        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView firstTextView = listItemView.findViewById(R.id.listItemName);
        // Get the version name from the current Place object and set this text on the name TextView
        firstTextView.setText(currentPlace.getPlaceTitle());


        /* second place ***********************************/
        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView secondTextView = listItemView.findViewById(R.id.listItemDesc);
        // Get the version number from the current Place object and set this text on the number TextView
        secondTextView.setText(currentPlace.getPlaceSubtitle());

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
        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView


        //backgorund
        View textContainer = listItemView.findViewById(R.id.card_view);
        //View playButtonContainter = listItemView.findViewById(R.id.play_button);
        //find the value of the color through below single line
        int color = ContextCompat.getColor(getContext(), viewBGColor);
        textContainer.setBackgroundColor(color);
        //playButtonContainter.setBackgroundColor(color);
        return listItemView;
    }
}
