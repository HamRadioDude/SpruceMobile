package com.example.sprucemobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Optional;

public class MainActivity extends AppCompatActivity {

    double costPerLine;
    double discount;
    Double costPerMonth;
    String linesEnt;
    Integer linesEnt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Right here, I shall define my logo to display on my title bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        // Next, I will define the buttons within my radio group

        final RadioButton cb1 = (RadioButton) findViewById(R.id.cb1);
        final RadioButton cb2 = (RadioButton) findViewById(R.id.cb2);
        final RadioButton cb3 = (RadioButton) findViewById(R.id.cb3);

        // Next, I will define the Edit Text "txtLines (number)
        final EditText lines = (EditText) findViewById(R.id.txtLines);

        // and the result window
        final TextView total = (TextView) findViewById(R.id.txtResult);

        // Lets not forget about the button

        Button calculate = (Button) findViewById(R.id.btnGetRate);

        //

        // We'll see what happens here, I'm trying to fix some problems with the instruction from the book which they failed to go over

//
//        lines.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if(lines.getText().length() < 1){
//                    lines.setText("1");
//
//
//                }
//            }
//        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                linesEnt=lines.getText().toString();
                DecimalFormat hun = new DecimalFormat("#.##");

                if (linesEnt == "" || linesEnt == null || linesEnt.equals("0") || linesEnt.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter the amount of phone lines", Toast.LENGTH_LONG).show();
                } else {

                    linesEnt2=Integer.parseInt(linesEnt.toString());
                    // First, no more than 6 lines, no less than 1.

                        if (linesEnt2 >= 1 && linesEnt2 <= 6) {
                        // Lets do the conditionals.
                            if (cb1.isChecked()) {
                            discount = .10;
                            costPerLine = 30.00;

                            } else if (cb2.isChecked()) {
                                discount = .15;
                                costPerLine = 35.00;
                            } else if (cb3.isChecked()) {
                                discount = .20;
                                costPerLine = 40.00;

                            } else {
                                discount = 0.00;
                                costPerLine = 25.00;
                            }

                            costPerMonth = ((costPerLine * linesEnt2) - ((costPerLine * linesEnt2) * discount));
                            total.setText("Total Monthly cost for " + linesEnt + " Lines, is: $" + hun.format(costPerMonth));
                    } else {
                        Toast.makeText(MainActivity.this, "Lines must be greater than  0 and less than 6", Toast.LENGTH_LONG).show();
                    }

                }






            }
        });


    }

}
