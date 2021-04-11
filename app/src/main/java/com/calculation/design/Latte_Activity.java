package com.calculation.design;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Latte_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latte_);
        final TextView textlattequntity = findViewById(R.id.textlattequntity);
        final TextView pricelatte = findViewById(R.id.pricelatte);
        final TextView pricepricelatte = findViewById(R.id.pricepricelatte);
        final Button btnminuslatte = findViewById(R.id.btnminuslatte);
        final Button btnbluslatte = findViewById(R.id.btnbluslatte);
        final Button lattecaculate = findViewById(R.id.lattecaculate);
        final Button savelatte = findViewById(R.id.savelatte);



        lattecaculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p = Integer.parseInt(textlattequntity.getText().toString());
                int r = Integer.parseInt(pricelatte.getText().toString());
                double pprice = p*r;


                pricepricelatte.setText( pprice + "");
            }
        });
        btnminuslatte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pa = Integer.parseInt(textlattequntity.getText().toString());
                int ss = pa-1;

                btnminuslatte.setText(ss+"");
            }
        });
        btnbluslatte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pa = Integer.parseInt(textlattequntity.getText().toString());
                int ssp = pa+1;

                btnbluslatte.setText(ssp+"");
            }
        });
    }
}