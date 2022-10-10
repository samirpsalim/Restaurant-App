package com.example.restaurantapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SupplierFragment extends Fragment {

    RecyclerView supplierview;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.suppliers,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        supplierview=view.findViewById(R.id.suppliers);
    }

    @Override
    public void onResume() {
        super.onResume();
        DataBaseHandler db=new DataBaseHandler(getContext());
        List<Supplier> suppliers=db.getSuppliers();
        supplierview.setAdapter(new SupplierAdapter(suppliers));
    }
}
