package com.toneloc.olympicsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
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
    Button button;
    EditText editTeam;
    int[] sampleImages = {R.drawable.image_1, R.drawable.image_2, R.drawable.image_3};
    String[] instructionText = new String[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set instructions from string resources
        instructionText[0] = getResources().getString(R.string.instructions_1);
        instructionText[1] = getResources().getString(R.string.instructions_2);
        instructionText[2] = getResources().getString(R.string.instructions_3);

        customCarouselView = (CarouselView) findViewById(R.id.customCarouselView);
        customCarouselLabel = (TextView) findViewById(R.id.customCarouselLabel);
        button = (Button) findViewById(R.id.btn_lets_play);

        customCarouselView.setPageCount(sampleImages.length);
        customCarouselView.setViewListener(viewListener);

        Team thisTeam = new Team(12, "TheBestTeamEver!");
        editTeam = (EditText) findViewById(R.id.team_edit_text);
        editTeam.setText(thisTeam.getRandomName());

        setButton();

        //this method should prevent the keyboard from annoyingly opening up when the app does
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    // To set custom views
    ViewListener viewListener = new ViewListener() {
        @Override
        public View setViewForPosition(int position) {

            View customView = getLayoutInflater().inflate(R.layout.view_custom, null);
            TextView labelTextView = (TextView) customView.findViewById(R.id.labelTextView);
            ImageView fruitImageView = (ImageView) customView.findViewById(R.id.fruitImageView);
            fruitImageView.setImageResource(sampleImages[position]);
            labelTextView.setText(instructionText[position]);

            return customView;
        }
    };

    public void setButton() {
        Button button = (Button) findViewById(R.id.btn_lets_play);
        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intentToGoToPickTeam = new Intent(MainActivity.this, PickTeamActivity.class);


                //get team name on submission
                String teamName = editTeam.getText().toString();
                intentToGoToPickTeam.putExtra("TEAM_NAME", teamName);
                startActivity(intentToGoToPickTeam);

            }
        });

    }

}

//pass in team name from main to (pick team activity and gameplay)
//add a filter
//add flags in the list view (partially done)
//put all thre medals in one view in order to maintain aligment
//check alignment on phones n stuff
//fix empty view bug

