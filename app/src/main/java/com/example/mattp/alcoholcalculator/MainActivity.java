package com.example.mattp.alcoholcalculator;

import android.content.Intent;
import android.net.Uri;
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

        Button buttonl1 = (Button) findViewById(R.id.buttlink1);
        buttonl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentlink1 = new Intent();
                intentlink1.setAction(Intent.ACTION_VIEW);
                intentlink1.addCategory(Intent.CATEGORY_BROWSABLE);
                intentlink1.setData(Uri.parse("https://cdn.shopify.com/s/files/1/0152/1201/files/BAC_chart_grande.jpg?6"));
                startActivity(intentlink1);
            }
        });

        Button buttonl2 = (Button) findViewById(R.id.buttlink2);
        buttonl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentlink2 = new Intent();
                intentlink2.setAction(Intent.ACTION_VIEW);
                intentlink2.addCategory(Intent.CATEGORY_BROWSABLE);
                intentlink2.setData(Uri.parse("https://www.angloinfo.com/how-to/malaysia/transport/driving/road-rules"));
                startActivity(intentlink2);
            }
        });
    }
}


