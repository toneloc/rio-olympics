package com.toneloc.olympicsapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GameplayActivity extends AppCompatActivity {

    SQLiteDatabase db;
    DatabaseHelper myDbHelper;
    TextView mTxtSelectedTeams;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);

        mTxtSelectedTeams = (TextView) findViewById(R.id.txt_selected_teams);

        Bundle extras = getIntent().getExtras();
        int[] ids = extras.getIntArray("SELECTIONS");
        String mTeamName = extras.getString("TEAM_NAME");

        mTxtSelectedTeams.setText(mTeamName);
        String country = Integer.toString(ids[0]);


        //create new team object
        //Team newTeam = new Team(0,);


    }
}
