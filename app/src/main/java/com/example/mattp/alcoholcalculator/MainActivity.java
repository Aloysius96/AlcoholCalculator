package com.example.mattp.alcoholcalculator;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //First button to move to PersonalityActivity class
        Button buttoncalc = (Button) findViewById(R.id.buttcalc);
        buttoncalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentstart = new Intent(MainActivity.this, PersonalityActivity.class);
                startActivity(intentstart);
            }
        });

        //Second button to move to DataExActivity class
        Button buttonex = (Button) findViewById(R.id.buttex);
        buttonex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentex = new Intent(MainActivity.this, DataExActivity.class);
                startActivity(intentex);
            }
        });

        //Third buttoon to launch a browser link about BAC legal chart
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

        //Fourth button to launch a browser link about malaysian transportation rules on drunk driving
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


