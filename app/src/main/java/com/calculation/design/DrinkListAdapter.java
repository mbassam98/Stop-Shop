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

//    @Override
//    public int getViewTypeCount() {
//        return LIST_ITEM_TYPE_COUNT;
//    }

    @Override
    public int getCount() {
        return drinks.size();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        Drink drink = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.drink_layout_item, parent, false);
        }
        // Lookup view for data population
        ImageView imgProduct = view.findViewById(R.id.imgProduct);
        TextView txtName = view.findViewById(R.id.txtName);
        // Populate the data into the template view using the data object
        imgProduct.setImageResource(drink.getImage());
        txtName.setText(drink.getDrink_name());
        // Return the completed view to render on screen
        return view;

    }
}