package com.calculation.design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListDrinksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hot_drinks);

        final ListView listDrinks = findViewById(R.id.listDrinks);

        SQLiteDatabaseAdapter ad = new SQLiteDatabaseAdapter(ListDrinksActivity.this);
        ad.open();
        ArrayList<Drink> drinks = ad.getAllDrinks();
        ad.close();

        DrinkListAdapter adapter = new DrinkListAdapter(this, drinks);
        listDrinks.setAdapter(adapter);

        listDrinks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Drink d = drinks.get(position);
                Intent i = new Intent(ListDrinksActivity.this, Customize_Drink_Activity.class);
                i.putExtra("id", d.get_id());
                startActivity(i);
            }
        });
    }
}