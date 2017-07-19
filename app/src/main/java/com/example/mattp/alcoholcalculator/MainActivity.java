package com.example.mattp.alcoholcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttoncalc = (Button) findViewById(R.id.buttcalc);
        buttoncalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentstart = new Intent(MainActivity.this, PersonalityActivity.class);
                startActivity(intentstart);
            }
        });

        Button buttonex = (Button) findViewById(R.id.buttex);
        buttonex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentex = new Intent(MainActivity.this, DataExActivity.class);
                startActivity(intentex);
            }
        });
    }
}


