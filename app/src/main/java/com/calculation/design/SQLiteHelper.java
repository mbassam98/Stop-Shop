package com.calculation.design;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class SQLiteHelper extends SQLiteOpenHelper {

    public static final int version = 1;

    Context mContext;

    public SQLiteHelper(Context context) {
        super(context, "stop_shoop.db", null, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE drinks (_id INTEGER PRIMARY KEY AUTOINCREMENT,drink_name varchar(20) NOT NULL,price float NOT NULL, image  varchar(111) NOT NULL);");
        db.execSQL("CREATE TABLE users (_id INTEGER PRIMARY KEY AUTOINCREMENT,user_name varchar(40) NOT NULL,password varchar(11) NOT NULL,facebook varchar(111) NOT NULL, latitude float NOT NULL,longtitude float NOT NULL);");
        db.execSQL("CREATE TABLE orders (_id int(11) NOT NULL,user_id int(11) NOT NULL,drinks_id int(11) NOT NULL,quantity int(3) NOT NULL,size varchar(10) NOT NULL,sugger varchar(10) NOT NULL,additions varchar(55) NOT NULL);");

        ArrayList<Drink> drinks = new ArrayList<>();
        drinks.add(new Drink(1, "Espresso", 5, R.drawable.espresso));
        drinks.add(new Drink(2, "Cappuccino", 3, R.drawable.cappuccino));
        drinks.add(new Drink(3, "Macchiato", 4, R.drawable.macciato));
        drinks.add(new Drink(4, "Mocha", 6, R.drawable.mocha));
        drinks.add(new Drink(5, "Latte", 2, R.drawable.latte));

        for (int i = 0; i < drinks.size(); i++) {
            Drink x = drinks.get(i);
            createDrinks(x.getDrink_name(), x.getPrice(), x.getImage(), db);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists drinks;");
        db.execSQL("drop table if exists users;");
        db.execSQL("drop table if exists orders;");

        this.onCreate(db);

    }

    public void createDrinks (String drink_name, float price, Integer image, SQLiteDatabase database) {
        ContentValues values = new ContentValues();
        values.put("drink_name", drink_name);
        values.put("price", price);
        values.put("image", image);
        database.insert("drinks", null, values);
    }

}
