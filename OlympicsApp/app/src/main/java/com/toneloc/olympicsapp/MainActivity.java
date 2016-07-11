package com.toneloc.olympicsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;
import com.synnapps.carouselview.ViewListener;

public class MainActivity extends AppCompatActivity  {

    CarouselView customCarouselView;
    TextView customCarouselLabel;
    Button pauseButton;
    EditText editTeam;

    int[] sampleImages = {R.drawable.image_1, R.drawable.image_2, R.drawable.image_3};
    String[] sampleTitles = {"Pick up to eight countries to represent your team", "As countries get medals, you get points!", "Play your friends!"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customCarouselView = (CarouselView) findViewById(R.id.customCarouselView);
        customCarouselLabel = (TextView) findViewById(R.id.customCarouselLabel);
        pauseButton = (Button) findViewById(R.id.pauseButton);

        customCarouselView.setPageCount(sampleImages.length);
        customCarouselView.setViewListener(viewListener);

        Team thisTeam = new Team(12, "TheBestTeamEver!");
        editTeam = (EditText) findViewById(R.id.team_edit_text);
        editTeam.setText(thisTeam.getRandomName());
    }

    // To set custom views
    ViewListener viewListener = new ViewListener() {
        @Override
        public View setViewForPosition(int position) {

            View customView = getLayoutInflater().inflate(R.layout.view_custom, null);
            TextView labelTextView = (TextView) customView.findViewById(R.id.labelTextView);
            ImageView fruitImageView = (ImageView) customView.findViewById(R.id.fruitImageView);
            fruitImageView.setImageResource(sampleImages[position]);
            labelTextView.setText(sampleTitles[position]);

            return customView;
        }
    };

}
//add a filter
//send a bundle of the array list of selected countries
//add flags in the list view
//create a new PickCountry.java class
//change Main activity to have a carousel view
