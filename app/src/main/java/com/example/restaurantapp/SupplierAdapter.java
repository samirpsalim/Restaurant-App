package com.example.restaurantapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SupplierAdapter extends RecyclerView.Adapter<SupplierHolder> {
    List<Supplier> suppliers;
    public SupplierAdapter(List<Supplier> suppliers) {
        this.suppliers=suppliers;
    }

    @NonNull
    @Override
    public SupplierHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SupplierHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_or_supplier,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SupplierHolder holder, int position) {
        holder.bind(suppliers.get(position));
    }

    @Override
    public int getItemCount() {
        return suppliers.size();
    }
}
