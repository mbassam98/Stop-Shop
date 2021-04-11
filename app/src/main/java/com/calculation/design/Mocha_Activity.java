package com.calculation.design;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Mocha_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mocha_);
        final TextView textmochaquntity = findViewById(R.id.textmochaquntity);
        final TextView pricemocha = findViewById(R.id.pricemocha);
        final TextView pricepricemocha = findViewById(R.id.pricepricemocha);
        final Button btnminusmocha = findViewById(R.id.btnminusmocha);
        final Button btnblusmocha = findViewById(R.id.btnblusmocha);
        final Button mochacaculate = findViewById(R.id.mochacaculate);
        final Button savemocha = findViewById(R.id.savemocha);



        mochacaculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p = Integer.parseInt(textmochaquntity.getText().toString());
                int r = Integer.parseInt(pricemocha.getText().toString());
                double pprice = p*r;


                pricepricemocha.setText( pprice + "");
            }
        });
        btnminusmocha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pa = Integer.parseInt(textmochaquntity.getText().toString());
                int ss = pa-1;

                btnminusmocha.setText(ss+"");
            }
        });
        btnblusmocha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pa = Integer.parseInt(textmochaquntity.getText().toString());
                int ssp = pa+1;

                btnblusmocha.setText(ssp+"");
            }
        });
    }
}