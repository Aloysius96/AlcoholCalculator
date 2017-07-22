package com.example.mattp.alcoholcalculator;

import android.content.Context;
import android.content.Intent;
import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.R.id.edit;
import static com.example.mattp.alcoholcalculator.R.id.editWeight;

public class CalcActivity extends AppCompatActivity {

    private EditText editText1, editText2, editText3, editText4;
    private TextView txtVal, txtVal1;
    private Button ansCalc;
    private Context context1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        final String drunk1 = "Not Drunk Yet";
        final String drunk2 = "Slightly Drunk";
        final String drunk3 = "Obviously Drunk";
        final String drunk4 = "Super Drunk";
        final String drunk5 = "Get help immediately";
        //holds strings that will display when totalbac value is calculated

        editText1 = (EditText) findViewById(R.id.editWeight);
        editText2 = (EditText) findViewById(R.id.editBev);
        editText3 = (EditText) findViewById(R.id.editPer);
        editText4 = (EditText) findViewById(R.id.editNum);

        double kglbs = getIntent().getExtras().getDouble("pounds");
        //collects the pound data is being push from the previous activity
        String convlbs = String.valueOf(kglbs);
        //converts the pushed data to string
        EditText passWeight = (EditText) findViewById(R.id.editWeight);
        passWeight.setText(convlbs);
        //passes the string to editWeight

        context1 = this.getApplicationContext();

        ansCalc = (Button) findViewById(R.id.buttoncalc);
        ansCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((editText1.getText().toString().trim().length() <= 0) ||
                        (editText2.getText().toString().trim().length() <= 0) ||
                        (editText3.getText().toString().trim().length() <= 0) ||
                        (editText4.getText().toString().trim().length() <= 0)){
                    Toast.makeText(CalcActivity.this, "Input a value to calculate!", Toast.LENGTH_SHORT).show();
                    //toast will display if one of the edittext has no input
                }
                else {

                    double mEdit1 = Double.parseDouble(editText1.getText().toString());
                    double mEdit2 = Double.parseDouble(editText2.getText().toString());
                    double mEdit3 = Double.parseDouble(editText3.getText().toString());
                    double mEdit4 = Double.parseDouble(editText4.getText().toString());

                    final double totalbac = ((150 / mEdit1) * (mEdit3 / 50)
                            * (mEdit2 * mEdit4) * (0.025));
                    //standard formula to calculate blood alcohol content

                    int tole = Toast.LENGTH_SHORT;
                    CharSequence conv = "Calculated!";
                    Toast toast = Toast.makeText(context1, conv, tole);
                    toast.show();
                    //toast displays if successfully calculated

                    txtVal = (TextView) findViewById(R.id.textBAC);
                    txtVal.setText(String.format("BAC Value: %.2f", totalbac));
                    //displays bac value

                    if (totalbac > 0.01 && totalbac < 0.08) {
                        txtVal1 = (TextView) findViewById(R.id.textOut);
                        txtVal1.setText("Outcome: " + drunk1);
                    } else if (totalbac > 0.08 && totalbac < 0.12) {
                        txtVal1 = (TextView) findViewById(R.id.textOut);
                        txtVal1.setText("Outcome: " + drunk2);
                    } else if (totalbac > 0.12 && totalbac < 0.15) {
                        txtVal1 = (TextView) findViewById(R.id.textOut);
                        txtVal1.setText("Outcome: " + drunk3);
                    } else if (totalbac > 0.15 && totalbac < 0.19) {
                        txtVal1 = (TextView) findViewById(R.id.textOut);
                        txtVal1.setText("Outcome: " + drunk4);
                    } else {
                        txtVal1 = (TextView) findViewById(R.id.textOut);
                        txtVal1.setText("Outcome: " + drunk5);
                    }
                    //displays outcome according to totalbac values
                }
            }
        });
    }
}
