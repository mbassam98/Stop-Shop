package com.calculation.design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

public class ListDrinksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_drinks);

        final ListView listDrinks = findViewById(R.id.listDrinks);

        String[] productNames = {
                "Expresso",
                "Cappuccino",
                "Mocciato",
                "Mocha",
                "Latte",
        };

        Integer[] productImages = {
                R.drawable.espresso,
                R.drawable.cappuccino,
                R.drawable.macciato,
                R.drawable.mocha,
                R.drawable.latte,
        };

        DrinkListAdapter adapter = new DrinkListAdapter(this, productNames, productImages);
        listDrinks.setAdapter(adapter);

        listDrinks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(ListDrinksActivity.this, Latte_Activity.class);
                startActivity(i);
            }
        });
    }
}