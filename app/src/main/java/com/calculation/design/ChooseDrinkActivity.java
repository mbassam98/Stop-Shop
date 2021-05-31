package com.calculation.design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseDrinkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_drink);

        final Button hothot = findViewById(R.id.hothot);
        final Button coolcool = findViewById(R.id.coolcool);

        hothot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ChooseDrinkActivity.this, List_hot_Drinks_Activity.class);
                startActivity(i);
            }
        });
        coolcool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ChooseDrinkActivity.this, Activity_list_cool_drink.class);
                startActivity(i);
            }
        });
    }
}