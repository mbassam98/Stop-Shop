package com.calculation.design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registere);
        final EditText edtyournames = findViewById(R.id.edtyournames);
        final EditText edtyourpassworde = findViewById(R.id.edtyourpassworde);
        final Button btngotologinee = findViewById(R.id.btngotologinee);

        final int id = getIntent().getIntExtra("id", 0);

        btngotologinee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = edtyournames.getText().toString();
                String Password = edtyourpassworde.getText().toString();
                SQLiteDatabaseAdapter ad = new SQLiteDatabaseAdapter(Register_Activity.this);
                ad.open();
                boolean isCreated = ad.createUser(Name, Password);
                ad.close();
                if(isCreated){
                    Toast.makeText(Register_Activity.this, "Create User", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Register_Activity.this, Logein_Activity.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(Register_Activity.this, "This user already exists", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}