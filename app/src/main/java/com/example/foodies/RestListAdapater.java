package com.example.foodies;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class RestListAdapater extends ArrayAdapter<Customlist> {   // USAGE OF ADAPTER



    //the list values in the List of type hero
    List<Customlist> restoList;

    //activity context
    Context myCtx;

    //the layout resource file for the list items
    int resource;

    //constructor initializing the values
    public RestListAdapater(Context myCtx, int resource, List<Customlist> restoList) {
        super(myCtx, resource, restoList);
        this.myCtx = myCtx;
        this.resource = resource;
        this.restoList = restoList;


    }

    //this will return the ListView Item as a View
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //we need to get the view of the xml for our list item
        //And for this we need a layoutinflater
        LayoutInflater layoutInflater = LayoutInflater.from(myCtx);

        //getting the view
        View view = layoutInflater.inflate(resource, null, false);

        //getting the view elements of the list from the view
        //ImageView imageView = view.findViewById(R.id.imageView);
        TextView textViewName = view.findViewById(R.id.textView3);
        TextView textViewLocation = view.findViewById(R.id.textView6);
        TextView textViewRating = view.findViewById(R.id.textView7);


        ImageView image1=view.findViewById(R.id.imageView0);

        //getting the hero of the specified position
        Customlist rest = restoList.get(position);

        //adding values to the list item
       // imageView.setImageDrawable(context.getResources().getDrawable(hero.getImage()));
        textViewName.setText(rest.getName());
        textViewLocation.setText(rest.getLocation());
        textViewRating.setText(rest.getRatings());


        AssetManager assetManager = myCtx.getAssets();
        Bitmap bitmap;

        InputStream inputStream;
        try {

            inputStream = assetManager.open(rest.getId()+"/"+rest.getImage1());
            bitmap=BitmapFactory.decodeStream(inputStream);
            image1.setImageBitmap(bitmap);
        } catch (IOException e) {
            Log.e("*******",e.toString());
            e.printStackTrace();
        }


        //adding a click listener to the button to remove item from the list

        //finally returning the view
        return view;
    }

    //this method will remove the item from the list

        //if response is negative nothing is being done
    }
