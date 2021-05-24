package com.calculation.design;

import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DrinkListAdapter extends ArrayAdapter<Drink> {

    private final Activity context;
    private final ArrayList<Drink> drinks;

    public DrinkListAdapter(Activity context, ArrayList<Drink> drinks) {
        super(context, 0, drinks);

        this.context = context;
        this.drinks = drinks;

    }


    @Override
    public int getCount() {
        return drinks.size();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        Drink drink = getItem(position);
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.drink_layout_item, parent, false);
        }

        ImageView imgProduct = view.findViewById(R.id.imgProduct);
        TextView txtName = view.findViewById(R.id.txtName);
        imgProduct.setImageResource(drink.getImage());
        txtName.setText(drink.getDrink_name());
        return view;

    }
}