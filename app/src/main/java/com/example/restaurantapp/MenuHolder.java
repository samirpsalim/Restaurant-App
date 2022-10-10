package com.example.restaurantapp;

import static java.lang.String.valueOf;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MenuHolder extends RecyclerView.ViewHolder {

    TextView item,price;

    public MenuHolder(@NonNull View itemView) {
        super(itemView);

    }

    public void bind(MenuItem item) {
        this.item=itemView.findViewById(R.id.item_or_supplier);
        price=itemView.findViewById(R.id.price_or_phone);
        this.item.setText(item.name);
        price.setText(Double.toString(item.price));

    }
}
