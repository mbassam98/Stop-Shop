package com.calculation.design;

public class Drink {
    private int _id;
    private String drink_name;
    private String type;
    private float price;
    private Integer image;

    public Drink(int _id, String drink_name, String type, float price, Integer image) {
        this._id = _id;
        this.drink_name = drink_name;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return drink_name;
    }
}
