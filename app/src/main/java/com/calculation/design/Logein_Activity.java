package com.calculation.design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Logein_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logein_);

        final EditText edtyourename = findViewById(R.id.edtyourename);
        final EditText edtyourpassword = findViewById(R.id.edtyourpassword);
        final Button btngotolistdrink = findViewById(R.id.btngotolistdrink);

        btngotolistdrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // int yourname = Integer.parseInt(edtyourename.getText().toString());
                // int password = Integer.parseInt(edtyourpassword.getText().toString());

                Intent i = new Intent(Logein_Activity.this, ListDrinksActivity.class);
                startActivity(i);
            }
        });

    }
}