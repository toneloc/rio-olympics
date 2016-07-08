package com.toneloc.olympicsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView txt = (TextView) findViewById(R.id.txt_country_name);

        Intent prevActivity = getIntent();
        String msg = prevActivity.getStringExtra("MSG");

        txt.setText(msg);
    }


}
