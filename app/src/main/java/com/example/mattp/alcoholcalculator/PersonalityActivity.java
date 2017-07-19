package com.example.mattp.alcoholcalculator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PersonalityActivity extends AppCompatActivity {

    private EditText weight;
    private Button presscon;
    private Context context;
    double pounds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personality);

        context = this.getApplicationContext();

        weight = (EditText) findViewById(R.id.pEditWeight);

        presscon = (Button) findViewById(R.id.buttcon) ;
        presscon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (weight.getText().toString().trim().length() <= 0) {
                    Toast.makeText(PersonalityActivity.this, "Input a value to continue!", Toast.LENGTH_SHORT).show();
                }
                else {
                    double mWeight = Double.parseDouble(weight.getText().toString());
                    pounds = mWeight * 2.2;

                    int duration = Toast.LENGTH_SHORT;
                    CharSequence conv = "Converted to Pounds!";
                    Toast toast = Toast.makeText(context, conv, duration);
                    toast.show();

                    Intent intentPers = new Intent(context, CalcActivity.class);
                    intentPers.putExtra("pounds", pounds);
                    startActivity(intentPers);
                }
            }
        });

    }
}
