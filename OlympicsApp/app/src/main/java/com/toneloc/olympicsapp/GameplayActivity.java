package com.toneloc.olympicsapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

public class GameplayActivity extends AppCompatActivity {

    TextView mTxtSelectedTeams;
    SQLiteDatabase db;
    DatabaseHelper myDbHelper;
    GridView mGridView;
    ArrayAdapter<String> mGridAdapter;
    ListView mListViewCountries;
    ResultsListCursorAdapter mResultsListCursorAdapter;
    ArrayList<Country> mSelectedCountriesArrayList;
    ArrayList<String> mSelectedCountryNamesForGridDisplay;
    TextView mRemainingMoney;
    TextView mTvTeamName;
    AlertDialog.Builder mAlert;
    String mTeamName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);

        Bundle extras = getIntent().getExtras();
        int[] ids = extras.getIntArray("SELECTIONS");
        String mTeamName = extras.getString("TEAM_NAME");


        mTvTeamName = (TextView) findViewById(R.id.txt_team_name);
        mTvTeamName.setText(mTeamName);


        myDbHelper = new DatabaseHelper(this);
        try {
            myDbHelper.openDatabase();
        } catch (SQLException sqle) {
            throw sqle;
        }

        populateListView();

        setGridView(ids);

    }

    public void populateListView() {
        // Get access to the underlying writable database
        db = myDbHelper.getReadableDatabase();
        // Query for items from the database and get a cursor back

        Cursor countryListCursor = db.query("countries", // a. table
                null, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        // Setup cursor adapter
        mResultsListCursorAdapter = new ResultsListCursorAdapter(this, countryListCursor, 0);

        // Find the ListView to populate
        mListViewCountries = (ListView) findViewById(R.id.lvItems);

        //add a header row
        View header = getLayoutInflater().inflate(R.layout.header_results, null);
        mListViewCountries.addHeaderView(header, null, false);

        // Attach cursor adapter to the ListView
        mListViewCountries.setAdapter(mResultsListCursorAdapter);
        mResultsListCursorAdapter.generateArrayListOfAllCountryObjects(countryListCursor);

    }

    public void setGridView(int[] ids) {
        mSelectedCountryNamesForGridDisplay = new ArrayList<>();
        mGridView = (GridView) findViewById(R.id.grid_selected_countries);

        for (int i = 0; i < ids.length; i++) {
            String name = mResultsListCursorAdapter.mArrayListOfAllCountryObjects.get(i).getmName();
            mSelectedCountryNamesForGridDisplay.add(name);
        }

        mGridAdapter = new ArrayAdapter<>(this, R.layout.grid_results_value, mSelectedCountryNamesForGridDisplay);
        mGridView.setAdapter(mGridAdapter);
    }
}
