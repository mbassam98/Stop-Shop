package com.calculation.design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class List_hot_Drinks_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hot_drinks);

        final ListView listDrinks = findViewById(R.id.listHotDrinks);

        SQLiteDatabaseAdapter ad = new SQLiteDatabaseAdapter(List_hot_Drinks_Activity.this);
        ad.open();
        ArrayList<Drink> drinks = ad.getHotDrinks();
        ad.close();

        DrinkListAdapter adapter = new DrinkListAdapter(this, drinks);
        listDrinks.setAdapter(adapter);

        listDrinks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Drink d = drinks.get(position);
                Intent i = new Intent(List_hot_Drinks_Activity.this, Customize_Drink_Activity.class);
                i.putExtra("id", d.get_id());
                startActivity(i);
            }
        });
    }
}