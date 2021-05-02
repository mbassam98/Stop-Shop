package com.calculation.design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                btngotolistdrink.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String Name = edtyourename.getText().toString();
                        String Password = edtyourpassword.getText().toString();
                        SQLiteDatabaseAdapter ad = new SQLiteDatabaseAdapter(Logein_Activity.this);
                        ad.open();
                        User usr = ad.loginUser(Name, Password);
                        ad.close();
                        if (usr == null) {
                            Toast.makeText(Logein_Activity.this, "Invalid user", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(Logein_Activity.this, "Correct user", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(Logein_Activity.this, ListDrinksActivity.class);
                            startActivity(i);
                        }
                        edtyourename.setText("");
                        edtyourpassword.setText("");
                    }
                });

            }
        });

    }
}
