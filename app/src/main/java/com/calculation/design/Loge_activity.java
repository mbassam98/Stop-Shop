package com.calculation.design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Loge_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loge_activity);

        final LinearLayout lyt_facebook = findViewById(R.id.lyt_facebook);
        final Button btnregistere = findViewById(R.id.btnregistere);
        final Button btnlogine = findViewById(R.id.btnlogine);


        btnlogine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Loge_activity.this, Logein_Activity.class);
                startActivity(i);
            }
        });

        btnregistere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Loge_activity.this, Register_Activity.class);
                startActivity(i);
            }
        });

        lyt_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}