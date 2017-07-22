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
    private Button presscon, pressifpounds;
    private Context context;
    double pounds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personality);

        context = this.getApplicationContext();

        weight = (EditText) findViewById(R.id.pEditWeight);

        //Button to calculate persons weight in KG to Pounds
        presscon = (Button) findViewById(R.id.buttcon) ;
        presscon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (weight.getText().toString().trim().length() <= 0) {
                    Toast.makeText(PersonalityActivity.this, "Input a value to continue!", Toast.LENGTH_SHORT).show();
                    //toast will show if there is no input inside edittextbox
                }
                else {
                    double mWeight = Double.parseDouble(weight.getText().toString());
                    pounds = mWeight * 2.2;
                    //standard formula to convert to pounds

                    int duration = Toast.LENGTH_SHORT;
                    CharSequence conv = "Converted to Pounds!";
                    Toast toast = Toast.makeText(context, conv, duration);
                    toast.show();
                    //another toast will show if successfully converted to pounds

                    Intent intentPers = new Intent(context, CalcActivity.class);
                    intentPers.putExtra("pounds", pounds);
                    startActivity(intentPers);
                    //pushes the converted data to the CalcActivity class
                }
            }
        });

        //if user does not want to convert to pounds
        pressifpounds = (Button) findViewById(R.id.buttifpounds);
        pressifpounds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //scans whether is there any input, if none it will proceed to go to the next activity
                //where the user has to input their own value of pounds
                if (weight.getText().toString().trim().length() <= 0){
                    double mWeight = 0;
                    pounds = mWeight;
                    Intent intentPersPound = new Intent(context, CalcActivity.class);
                    intentPersPound.putExtra("pounds", pounds);
                    startActivity(intentPersPound);
                }
                //if there is an input, toast will prompt and user needs to remove the value to continue
                else if(weight.getText().toString().trim().length() >= 1)
                {
                    Toast.makeText(PersonalityActivity.this, "To continue, remove the value in the box", Toast.LENGTH_SHORT).show();
                }



            }
        });

    }
}
