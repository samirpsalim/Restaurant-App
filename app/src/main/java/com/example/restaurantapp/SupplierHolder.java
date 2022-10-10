package com.example.restaurantapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SupplierHolder extends RecyclerView.ViewHolder {

    TextView supplier,phone;

    public SupplierHolder(View inflate) {
        super(inflate);
    }

    public void bind(Supplier supplier) {
        this.supplier=itemView.findViewById(R.id.item_or_supplier);
        phone=itemView.findViewById(R.id.price_or_phone);
        this.supplier.setText(supplier.name);
        phone.setText(supplier.phone);
    }
}
