package com.toneloc.olympicsapp;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    DatabaseHelper myDbHelper;
    GridView mGridView;
    ArrayAdapter<Integer> mGridAdapter;
    ListView mListViewCountries;
    CountryListCursorAdapter mCountryListCursorAdapter;
    ArrayList<Integer> mSelectedCountriesArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDbHelper = new DatabaseHelper(this);

        try {
            myDbHelper.createDatabase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            myDbHelper.openDatabase();

        } catch (SQLException sqle) {
            throw sqle;
        }

        populateListView();

        setCountryListOnClick();

        mSelectedCountriesArrayList = new ArrayList<Integer>();

        setGridView();


    }

    public void populateListView() {
        // Get access to the underlying writeable database
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

        // Find ListView to populate
        mListViewCountries = (ListView) findViewById(R.id.lvItems);
        // Setup cursor adapter using cursor from last step
        mCountryListCursorAdapter = new CountryListCursorAdapter(this, countryListCursor, 0);
        // Attach cursor adapter to the ListView
        mListViewCountries.setAdapter(mCountryListCursorAdapter);
    }

    public void setCountryListOnClick() {
        AdapterView.OnItemClickListener listViewOnItemClick = new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                int mSelectedItem = position;
                mCountryListCursorAdapter.notifyDataSetChanged();

                //i get the int position but
                Toast.makeText(MainActivity.this, Integer.toString(position) + ": " + mCountryListCursorAdapter.getItem(position), Toast.LENGTH_SHORT).show();

                addSelectedCountryToArray(position);
            }
        };

        mListViewCountries.setOnItemClickListener(listViewOnItemClick);
    }

    public ArrayList<Integer> addSelectedCountryToArray(int selectedCountry) {

        //eventually should be an array of country objects
        //and on click should add a country object to the array list

        if (mSelectedCountriesArrayList.size() < 8) {
            mSelectedCountriesArrayList.add(selectedCountry);


        } else {
            Toast.makeText(MainActivity.this, "You may only select a maximum of 8 countries.", Toast.LENGTH_SHORT).show();
        }

        return mSelectedCountriesArrayList;

    }

    public void setGridView() {
        //this should be a grid view of country objects, probably .. .  .

        mGridView = (GridView) findViewById(R.id.grid_selected_countries);
        mGridAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, mSelectedCountriesArrayList);
        mGridView.setAdapter(mGridAdapter);


    }

}

