package com.example.restaurantapp;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

public class Utils {

    public static void saveToPreference(Context context, String userName, String password,int LoggedIn) {
        SharedPreferences sh= context.getSharedPreferences("LoginData",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sh.edit();
        myEdit.putString("username",userName);
        myEdit.putString("password", password);
        myEdit.putInt("LoggedIn",LoggedIn);
        myEdit.apply();
        myEdit.commit();
    }
}
