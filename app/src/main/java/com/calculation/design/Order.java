package com.calculation.design;

public class Order {

    private int _id;
    private int user_id;
    private int drinks_id;
    private int quantity;
    private String size;
    private String sugger;
    private String additions;

    public Order(int _id, int user_id, int drinks_id, int quantity, String size, String sugger, String additions) {
        this._id = _id;
        this.user_id = user_id;
        this.drinks_id = drinks_id;
        this.quantity = quantity;
        this.size = size;
        this.sugger = sugger;
        this.additions = additions;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getDrinks_id() {
        return drinks_id;
    }

    public void setDrinks_id(int drinks_id) {
        this.drinks_id = drinks_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSugger() {
        return sugger;
    }

    public void setSugger(String sugger) {
        this.sugger = sugger;
    }

    public String getAdditions() {
        return additions;
    }

    public void setAdditions(String additions) {
        this.additions = additions;
    }
}
