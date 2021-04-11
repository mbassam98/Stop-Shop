package com.calculation.design;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Macciato_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macciato_);
        final TextView textmacciatoquntity = findViewById(R.id.textmacciatoquntity);
        final TextView pricemacciato = findViewById(R.id.pricemacciato);
        final TextView pricepricemacciato = findViewById(R.id.pricepricemacciato);
        final Button btnminusmacciato = findViewById(R.id.btnminusmacciato);
        final Button btnblusmacciato = findViewById(R.id.btnblusmacciato);
        final Button macciatocaculate = findViewById(R.id.macciatocaculate);
        final Button savemacciato = findViewById(R.id.savemacciato);



        macciatocaculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p = Integer.parseInt(textmacciatoquntity.getText().toString());
                int r = Integer.parseInt(pricemacciato.getText().toString());
                double pprice = p*r;


                pricepricemacciato.setText( pprice + "");
            }
        });
        btnminusmacciato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pa = Integer.parseInt(textmacciatoquntity.getText().toString());
                int ss = pa-1;

                btnminusmacciato.setText(ss+"");
            }
        });
        btnblusmacciato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pa = Integer.parseInt(textmacciatoquntity.getText().toString());
                int ssp = pa+1;

                btnblusmacciato.setText(ssp+"");
            }
        });
    }
}