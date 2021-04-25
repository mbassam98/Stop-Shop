package com.calculation.design;

public class Drink {
    private int _id;
    private String drink_name;
    private float price;
    private String image;

    public Drink(int _id, String drink_name, float price, String image) {
        this._id = _id;
        this.drink_name = drink_name;
        this.price = price;
        this.image = image;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getDrink_name() {
        return drink_name;
    }

    public void setDrink_name(String drink_name) {
        this.drink_name = drink_name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
