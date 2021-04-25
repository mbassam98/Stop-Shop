package com.calculation.design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registere);
        final EditText edtyournames = findViewById(R.id.edtyournames);
        final EditText edtyourpassworde = findViewById(R.id.edtyourpassworde);
        final Button btngotologinee = findViewById(R.id.btngotologinee);

        btngotologinee.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             int yourname = Integer.parseInt(edtyournames.getText().toString());
             int password = Integer.parseInt(edtyourpassworde.getText().toString());
         }
     });

    btngotologinee.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            Intent i = new Intent(Register_Activity.this,Logein_Activity.class);
            startActivity(i);
        }
    });


    }
}