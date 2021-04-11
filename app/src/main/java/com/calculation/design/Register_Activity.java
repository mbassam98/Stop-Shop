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
        final EditText edtyourname = findViewById(R.id.edtyourname);
        final EditText edtpassword = findViewById(R.id.edtpassword);
        final Button btngotologin = findViewById(R.id.btngotologin);
        final Button btnsaveregistere = findViewById(R.id.btnsaveregistere);

     btnsaveregistere.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             int yourname = Integer.parseInt(edtyourname.getText().toString());
             int password = Integer.parseInt(edtpassword.getText().toString());
         }
     });

    btngotologin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            Intent i = new Intent(Register_Activity.this,Logein_Activity.class);
            startActivity(i);
        }
    });


    }
}