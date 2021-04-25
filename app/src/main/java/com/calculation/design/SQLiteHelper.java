package com.calculation.design;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    public static final int version = 1;


    public SQLiteHelper(Context context){
        super(context, "stop_shoop.db", null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE drinks (_id INTEGER PRIMARY KEY AUTOINCREMENT,drink_name varchar(20) NOT NULL,price float NOT NULL, image  varchar(111) NOT NULL);");
        db.execSQL("CREATE TABLE users (_id INTEGER PRIMARY KEY AUTOINCREMENT,user_name varchar(40) NOT NULL,password varchar(11) NOT NULL,facebook varchar(111) NOT NULL, latitude float NOT NULL,longtitude float NOT NULL);");
        db.execSQL("CREATE TABLE orders (_id int(11) NOT NULL,user_id int(11) NOT NULL,drinks_id int(11) NOT NULL,quantity int(3) NOT NULL,size varchar(10) NOT NULL,sugger varchar(10) NOT NULL,additions varchar(55) NOT NULL);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists drinks;");
        db.execSQL("drop table if exists users;");
        db.execSQL("drop table if exists orders;");

        this.onCreate(db);

    }
}
