package com.calculation.design;

public class User {
    private int _id;
    private String user_name;
    private String password;
    private String facebook;
    private Float latitude;
    private Float longtitude;

    public User(int _id, String user_name, String password, String facebook, Float latitude, Float longtitude) {
        this._id = _id;
        this.user_name = user_name;
        this.password = password;
        this.facebook = facebook;
        this.latitude = latitude;
        this.longtitude = longtitude;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(Float longtitude) {
        this.longtitude = longtitude;
    }
}
