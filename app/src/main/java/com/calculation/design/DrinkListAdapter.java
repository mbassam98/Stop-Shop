package com.calculation.design;

import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkListAdapter  extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] productNames;
    private final Integer[] productImages;

    public DrinkListAdapter(Activity context, String[] productNames, Integer[] productImages) {
        super(context, R.layout.drink_layout_item, productNames);

        this.context=context;
        this.productNames=productNames;
        this.productImages=productImages;

    }

    public View getView(int position,View view,ViewGroup parent) {

        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.drink_layout_item, null,true);

        ImageView imgProduct = rowView.findViewById(R.id.imgProduct);
        TextView txtName = rowView.findViewById(R.id.txtName);

        txtName.setText(productNames[position]);
        imgProduct.setImageResource(productImages[position]);

        return rowView;

    };
}