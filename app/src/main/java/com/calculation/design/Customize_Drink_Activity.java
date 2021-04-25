package com.calculation.design;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Customize_Drink_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize__drink_);

        final ImageView imagebacktolistdrink = findViewById(R.id.imagebacktolistdrink);
        final TextView textquantity = findViewById(R.id.textquantity);
        final ImageButton btnblus = findViewById(R.id.btnblus);
        final ImageButton btnminuse = findViewById(R.id.btnminuse);
        final ImageView smallsize = findViewById(R.id.smallsize);
        final ImageView medeumsize = findViewById(R.id.medeumsize);
        final ImageView bigsize = findViewById(R.id.bigsize);
        final ImageView imgonesuger = findViewById(R.id.imgonesuger);
        final ImageView imgtwosuger = findViewById(R.id.imgtwosuger);
        final ImageView imgthreesuger = findViewById(R.id.imgthreesuger);
        final ImageView imgnosuger = findViewById(R.id.imgnosuger);
        final ImageView imgcream = findViewById(R.id.imgcream);
        final ImageView imgother = findViewById(R.id.imgother);
        final TextView txtprice1 = findViewById(R.id.txtprice1);
        final TextView txtprice23 = findViewById(R.id.txtprice23);

        btnblus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p = Integer.parseInt(txtprice1.getText().toString());
                double o = p + 1;
                textquantity.setText( o + "");
            }
        });

        btnminuse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int l = Integer.parseInt(txtprice1.getText().toString());
                double f = l + 1;
                txtprice1.setText( f + "");
                txtprice23.setText(f+"");
            }


        });

    }
}