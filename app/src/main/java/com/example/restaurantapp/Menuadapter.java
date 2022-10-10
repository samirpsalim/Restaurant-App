package com.example.restaurantapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Menuadapter extends RecyclerView.Adapter<MenuHolder> {

    List<MenuItem> menulist;

    public Menuadapter(List<MenuItem> menulist) {
        this.menulist=menulist;
    }

    @NonNull
    @Override
    public MenuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new MenuHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_or_supplier,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MenuHolder holder, int position) {
        holder.bind(menulist.get(position));
    }

    @Override
    public int getItemCount() {
        return menulist.size();
    }
}
