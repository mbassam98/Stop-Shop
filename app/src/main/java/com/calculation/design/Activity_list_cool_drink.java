package com.calculation.design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Activity_list_cool_drink extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_cool_drink);

        final ListView listCoolDrinks = findViewById(R.id.listCoolDrinks);

        SQLiteDatabaseAdapter ad = new SQLiteDatabaseAdapter(Activity_list_cool_drink.this);
        ad.open();
        ArrayList<Drink> drinks = ad.getCollDrinks();
        ad.close();

        DrinkListAdapter adapter = new DrinkListAdapter(this, drinks);
        listCoolDrinks.setAdapter(adapter);

        listCoolDrinks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Drink d = drinks.get(position);
                Intent i = new Intent(Activity_list_cool_drink.this, Customize_Drink_Activity.class);
                i.putExtra("id", d.get_id());
                startActivity(i);
            }
        });
    }
}