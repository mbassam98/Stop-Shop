package com.calculation.design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ListDrinksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_drinks);
        final ImageView imgbacklogein = findViewById(R.id.imgbacklogein);
        final LinearLayout lytespresso = findViewById(R.id.lytespresso);
        final LinearLayout lytcappuccino = findViewById(R.id.lytcappuccino);
        final LinearLayout lytmacciato = findViewById(R.id.lytmacciato);
        final LinearLayout lytmocha = findViewById(R.id.lytmocha);
        final LinearLayout lytlatte = findViewById(R.id.lytlatte);

        imgbacklogein.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListDrinksActivity.this,Logein_Activity.class);
                startActivity(i);
            }
        });

        lytespresso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListDrinksActivity.this,Espresso_Activity.class);
                startActivity(i);

            }
        });
        lytcappuccino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListDrinksActivity.this,Cappuccino_Activity.class);
                startActivity(i);

            }
        });
        lytmacciato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListDrinksActivity.this,Macciato_Activity.class);
                startActivity(i);

            }
        });
        lytmocha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListDrinksActivity.this,Mocha_Activity.class);
                startActivity(i);

            }
        });
        lytlatte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListDrinksActivity.this,Latte_Activity.class);
                startActivity(i);

            }
        });
    }
}