package com.example.android.materialdesigncodelab;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_POSITION = "position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        int position = getIntent().getIntExtra(EXTRA_POSITION, 0);

        TypedArray imageArray = getResources().obtainTypedArray(R.array.places_picture);
        Drawable[] imageDrawable = new Drawable[imageArray.length()];
        for (int i = 0; i < imageDrawable.length; i++) {
            imageDrawable[i] = imageArray.getDrawable(i);
        }

        ImageView placeImage = (ImageView) findViewById(R.id.image);
        placeImage.setImageDrawable(imageDrawable[position % imageDrawable.length]);

        String[] places = getResources().getStringArray(R.array.places);
        collapsingToolbarLayout.setTitle(places[position % places.length]);

        String[] placeDetails = getResources().getStringArray(R.array.place_details);
        TextView placeDetail = (TextView) findViewById(R.id.place_detail);
        placeDetail.setText(placeDetails[position % placeDetails.length]);

        String[] placeLocations = getResources().getStringArray(R.array.place_locations);
        TextView placeLocation = (TextView) findViewById(R.id.place_location);
        placeLocation.setText(placeLocations[position % placeLocations.length]);
    }
}
