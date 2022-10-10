package com.example.restaurantapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class PagerActivity extends AppCompatActivity {

    TabLayout tb;
    ViewPager2 viewPager;
    MyAdapter adapter=null;
    TextView username;
    SharedPreferences sh;
    Button logout;
    FloatingActionButton button;
    int currentTab=0;
    private String[] labels = new String[]{"Suppliers", "Menu", "Locations"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager_main);
        tb=findViewById(R.id.tabs);
        viewPager=findViewById(R.id.pager);
        adapter = new MyAdapter(this, labels.length);
        username=findViewById(R.id.username);
        sh=getSharedPreferences("LoginData",MODE_PRIVATE);
        String user=sh.getString("username","");
        username.setText(user);
        viewPager.setAdapter(adapter);
        new TabLayoutMediator(tb, viewPager,
                (tab, position) -> {
                    tab.setText(labels[position]);
                }).attach();
        tb.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                currentTab=tab.getPosition();
                if(currentTab==2){
                    button.setVisibility(View.GONE);
                }
                else{
                    button.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        logout=findViewById(R.id.logout_button);
        logout.setOnClickListener(this::logOut);
        button=findViewById(R.id.addition_button);
        button.setOnClickListener(this::floatingButtonAction);

    }

    private void floatingButtonAction(View view) {
            SupplierDialog addsupplier=new SupplierDialog(this,currentTab);
            addsupplier.show();
            addsupplier.getWindow().setLayout(600, 550);

    }

    private void logOut(View view) {
        Utils.saveToPreference(this,"","",0);
        Intent intent=new Intent(this,MainActivity.class);
        finish();
        startActivity(intent);
    }
}
