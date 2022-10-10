package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sh=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sh=getSharedPreferences("LoginData",MODE_PRIVATE);
        int loggedIn=sh.getInt("LoggedIn",0);
        if(loggedIn==1)
        {
            goToNext();
        }
    }

    public void goToNext() {
        Intent intent= new Intent(this, PagerActivity.class);
        finish();
        startActivity(intent);
    }
}