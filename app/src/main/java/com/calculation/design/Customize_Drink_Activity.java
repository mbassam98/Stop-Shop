package com.calculation.design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Customize_Drink_Activity extends AppCompatActivity {

    public double calculateTotalPrice(int quantity, double price) {

        return quantity * price;
    }

    int quantity = 1;
    String size = "";
    String sugger = "";
    String additions = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize__drink_);

        final TextView textquantity = findViewById(R.id.textquantity);
        final ImageButton btnblus = findViewById(R.id.btnblus);
        final ImageButton btnminuse = findViewById(R.id.btnminuse);
        final ImageView smallsize = findViewById(R.id.smallsize);
        final ImageView medeumsize = findViewById(R.id.medeumsize);
        final ImageView bigsize = findViewById(R.id.bigsize);
        final ImageView imgonesuger = findViewById(R.id.imgonesuger);
        final ImageView imgtwosuger = findViewById(R.id.imgtwosuger);
        final ImageView imgthreesuger = findViewById(R.id.imgthreesuger);
        final ImageView imgnosuger = findViewById(R.id.imgnosuger);
        final ImageView imgcream = findViewById(R.id.imgcream);
        final ImageView imgother = findViewById(R.id.imgother);
        final ImageView customsDrinkImage = findViewById(R.id.customsDrinkImage);
        final TextView txtprice1 = findViewById(R.id.txtprice1);
        final TextView customDrinkName = findViewById(R.id.customDrinkName);
        final TextView txtprice23 = findViewById(R.id.txtprice23);
        final Button btnaddtocart = findViewById(R.id.btnaddtocart);

        final int id = getIntent().getIntExtra("id", 0);
        SQLiteDatabaseAdapter ad = new SQLiteDatabaseAdapter(Customize_Drink_Activity.this);
        ad.open();
        Drink drink = ad.getDrink(id);
        ad.close();

        txtprice1.setText(drink.getPrice() + "");
        customDrinkName.setText(drink.getDrink_name() + "");
        customsDrinkImage.setImageResource(drink.getImage());
        textquantity.setText(quantity + "");
        txtprice23.setText(calculateTotalPrice(quantity, drink.getPrice()) + "");

        btnblus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                quantity = quantity + 1;
                textquantity.setText(quantity + "");
                txtprice23.setText(calculateTotalPrice(quantity, drink.getPrice()) + "");
            }
        });
        btnminuse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity == 1) {
                    return;
                }
                quantity = quantity - 1;
                textquantity.setText(quantity + "");
                txtprice23.setText(calculateTotalPrice(quantity, drink.getPrice()) + "");
            }
        });

        smallsize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size = "small";
                smallsize.setColorFilter(new PorterDuffColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP));
                medeumsize.setColorFilter(null);
                bigsize.setColorFilter(null);
            }
        });
        medeumsize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size = "medium";
                smallsize.setColorFilter(null);
                medeumsize.setColorFilter(new PorterDuffColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP));
                bigsize.setColorFilter(null);
            }
        });
        bigsize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size = "big";
                smallsize.setColorFilter(null);
                medeumsize.setColorFilter(null);
                bigsize.setColorFilter(new PorterDuffColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP));
            }
        });

        imgonesuger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sugger = "one";
                imgonesuger.setColorFilter(new PorterDuffColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP));
                imgtwosuger.setColorFilter(null);
                imgthreesuger.setColorFilter(null);
                imgnosuger.setColorFilter(null);
            }
        });
        imgtwosuger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sugger = "two";
                imgonesuger.setColorFilter(null);
                imgtwosuger.setColorFilter(new PorterDuffColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP));
                imgthreesuger.setColorFilter(null);
                imgnosuger.setColorFilter(null);
            }
        });
        imgthreesuger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sugger = "three";
                imgonesuger.setColorFilter(null);
                imgtwosuger.setColorFilter(null);
                imgthreesuger.setColorFilter(new PorterDuffColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP));
                imgnosuger.setColorFilter(null);
            }
        });
        imgnosuger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sugger = "no";
                imgonesuger.setColorFilter(null);
                imgtwosuger.setColorFilter(null);
                imgthreesuger.setColorFilter(null);
                imgnosuger.setColorFilter(new PorterDuffColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP));
            }
        });

        imgcream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                additions = "cream";
                imgcream.setColorFilter(new PorterDuffColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP));
                imgother.setColorFilter(null);
            }
        });
        imgother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                additions = "other";
                imgcream.setColorFilter(null);
                imgother.setColorFilter(new PorterDuffColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP));
            }
        });


        btnaddtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabaseAdapter ad = new SQLiteDatabaseAdapter(Customize_Drink_Activity.this);
                ad.open();
                ad.createOrder(1, drink.get_id(), quantity, size, sugger, additions);
                ad.close();

                Toast.makeText(Customize_Drink_Activity.this, "Order created", Toast.LENGTH_LONG).show();

                Intent i = new Intent(Customize_Drink_Activity.this, MapsActivity.class);
                startActivity(i);
            }
        });
    }
}