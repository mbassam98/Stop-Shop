package com.calculation.design;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Cappuccino_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cappuccino_);
        final TextView textcappuccinoquntity = findViewById(R.id.textcappuccinoquntity);
        final TextView pricecappuccino = findViewById(R.id.pricecappuccino);
        final TextView pricepricecappuccino = findViewById(R.id.pricepricecappuccino);
        final Button btnminuscappuccion = findViewById(R.id.btnminuscappuccion);
        final Button btnblusespresso = findViewById(R.id.btnblusespresso);
        final Button cappuccinocaculate = findViewById(R.id.cappuccinocaculate);
        final Button savecappuccino = findViewById(R.id.savecappuccino);



        cappuccinocaculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p = Integer.parseInt(textcappuccinoquntity.getText().toString());
                int r = Integer.parseInt(pricecappuccino.getText().toString());
                double pprice = p*r;


                pricepricecappuccino.setText( pprice + "");
            }
        });
        btnminuscappuccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pa = Integer.parseInt(textcappuccinoquntity.getText().toString());
                int ss = pa-1;

                btnminuscappuccion.setText(ss+"");
            }
        });
        btnblusespresso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pa = Integer.parseInt(textcappuccinoquntity.getText().toString());
                int ssp = pa+1;

                btnblusespresso.setText(ssp+"");
            }
        });
    }
}