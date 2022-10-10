package com.example.restaurantapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyAdapter extends FragmentStateAdapter {

    int size=0;
    public MyAdapter(@NonNull FragmentActivity fragmentActivity, int length) {
        super(fragmentActivity);
        size=length;
    }

    // return fragments at every position
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new SupplierFragment();
            case 1:
                return new MenuFragment();
            case 2:
                return new LocationFragment();
        }
        return null;
    }


    @Override
    public int getItemCount() {
        return size;
    }
}
