package com.calculation.design;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SQLiteDatabaseAdapter {

    SQLiteDatabase database;
    SQLiteHelper sqliteHelper;

    public SQLiteDatabaseAdapter(Context context) {
        this.sqliteHelper = new SQLiteHelper(context);
    }

    public void open() {
        this.database = sqliteHelper.getWritableDatabase();
    }

    public void close() {
        this.database.close();
    }

    public boolean createUser(String user_name, String password) {
        Cursor cursor = database.query("users", null, "user_name='" + user_name + "'", null, null, null, null);
        if(cursor.getCount() != 0){
            return false;
        }
        ContentValues values = new ContentValues();
        values.put("user_name", user_name);
        values.put("password", password);
        values.put("facebook", "");
        values.put("latitude", 0);
        values.put("longtitude", 0);
        database.insert("users", null, values);
        return true;
    }

    public void createUser(String user_name, String facebook, String password, float latitude,float longtitude) {
        ContentValues values = new ContentValues();
        values.put("user_name", user_name);
        values.put("password", password);
        values.put("facebook", facebook);
        values.put("latitude", latitude);
        values.put("longtitude", longtitude);
        database.insert("users", null, values);
    }

    public User getUserById(int id){
        List<User> users = new ArrayList<User>();
        Cursor cursor = database.query("users", null, "_id=" + id, null, null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            int _id = cursor.getInt(0);
            String user_name = cursor.getString(1);
            String password = cursor.getString(2);
            String facebook = cursor.getString(3);
            float latitude = cursor.getFloat(4);
            float longtitude = cursor.getFloat(5);
            users.add(new User(_id,user_name, password,facebook, latitude, longtitude));
            cursor.moveToNext();
        }
        cursor.close();
        return users.get(0);
    }

    public User loginUser(String userName, String passWord){
        List<User> users = new ArrayList<User>();
        Cursor cursor = database.query("users", null, "user_name='" + userName + "' AND password='" + passWord + "'", null, null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            int _id = cursor.getInt(0);
            String user_name = cursor.getString(1);
            String password = cursor.getString(2);
            String facebook = cursor.getString(3);
            float latitude = cursor.getFloat(4);
            float longtitude = cursor.getFloat(5);
            users.add(new User(_id,user_name, password,facebook, latitude, longtitude));
            cursor.moveToNext();
        }
        cursor.close();
        if(users.size() == 0){
            return null;
        }
        return users.get(0);
    }

    ////////////////////////////////////////////

    public void createDrinks (String drink_name, float price, Integer image) {
        ContentValues values = new ContentValues();
        values.put("drink_name", drink_name);
        values.put("price", price);
        values.put("image", image);
        database.insert("drinks", null, values);
    }

    public ArrayList<Drink> getAllDrinks(){
        ArrayList<Drink> drinks =new ArrayList<Drink>();
        Cursor cursor = database.query("drinks", null, null, null, null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            String drink_name = cursor.getString(1);
            String type = cursor.getString(2);
            float price = cursor.getFloat(3);
            Integer image = cursor.getInt(4);
            drinks.add(new Drink(id,drink_name,type, price,image));
            cursor.moveToNext();
        }
        cursor.close();
        return drinks;
    }

    public ArrayList<Drink> getHotDrinks(){
        ArrayList<Drink> drinks =new ArrayList<Drink>();
        Cursor cursor = database.query("drinks", null, "type='hot'", null, null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            String drink_name = cursor.getString(1);
            String type = cursor.getString(2);
            float price = cursor.getFloat(3);
            Integer image = cursor.getInt(4);
            drinks.add(new Drink(id,drink_name,type, price,image));
            cursor.moveToNext();
        }
        cursor.close();
        return drinks;
    }

    public ArrayList<Drink> getCollDrinks(){
        ArrayList<Drink> drinks =new ArrayList<Drink>();
        Cursor cursor = database.query("drinks", null, "type='cool'", null, null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            String drink_name = cursor.getString(1);
            String type = cursor.getString(2);
            float price = cursor.getFloat(3);
            Integer image = cursor.getInt(4);
            drinks.add(new Drink(id,drink_name,type, price,image));
            cursor.moveToNext();
        }
        cursor.close();
        return drinks;
    }

    public Drink getDrink(int _id){
        ArrayList<Drink> drinks =new ArrayList<Drink>();
        Cursor cursor = database.query("drinks", null, "_id=" + _id, null, null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            String drink_name = cursor.getString(1);
            String type = cursor.getString(2);
            float price = cursor.getFloat(3);
            Integer image = cursor.getInt(4);
            drinks.add(new Drink(id,drink_name,type, price,image));
            cursor.moveToNext();
        }
        cursor.close();
        return drinks.get(0);
    }

    ////////////////////////////////////

    public void createOrder( int user_id, int drinks_id, int quantity, String size, String sugger, String additions) {
        ContentValues values = new ContentValues();
        values.put("user_id", user_id);
        values.put("drinks_id", drinks_id);
        values.put("quantity", quantity);
        values.put("size", size);
        values.put("sugger", sugger);
        values.put("additions", additions);
        database.insert("Orders", null, values);
    }

    public List<Order> getAllOrders(){
        List<Order> orders =new ArrayList<Order>();
        Cursor cursor = database.query("orders", null, null, null, null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            int user_id = cursor.getInt(1);
            int drink_id = cursor.getInt(2);
            int quantity = cursor.getInt(3);
            String size = cursor.getString(4);
            String sugger = cursor.getString(5);
            String additions = cursor.getString(6);
            orders.add(new Order(id, user_id,drink_id, quantity,size,sugger,additions));
            cursor.moveToNext();
        }
        cursor.close();
        return orders;
    }

    public void deleteOrder(int id) {
        database.delete("orders", "_id=" + id, null);
    }

}
