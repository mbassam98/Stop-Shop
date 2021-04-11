package com.calculation.design;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Espresso_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espresso_);
       final TextView textespressoquntity = findViewById(R.id.textespressoquntity);
       final TextView priceespresso = findViewById(R.id.priceespresso);
       final TextView priceprice = findViewById(R.id.priceprice);
       final Button btnminusespresso = findViewById(R.id.btnminusespresso);
       final Button btnblusespresso = findViewById(R.id.btnblusespresso);
       final Button espressocaculate = findViewById(R.id.espressocaculate);
       final Button savesepresso = findViewById(R.id.saveespresso);



        espressocaculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p = Integer.parseInt(textespressoquntity.getText().toString());
                int r = Integer.parseInt(priceespresso.getText().toString());
                double pprice = p*r;


                priceprice.setText( pprice + "");
            }
        });
        btnminusespresso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pa = Integer.parseInt(textespressoquntity.getText().toString());
                int ss = pa-1;

                btnminusespresso.setText(ss+"");
            }
        });
        btnblusespresso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pa = Integer.parseInt(textespressoquntity.getText().toString());
                int ssp = pa+1;

                btnblusespresso.setText(ssp+"");
            }
        });
    }
}