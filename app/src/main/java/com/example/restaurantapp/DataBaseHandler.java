package com.example.restaurantapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Editable;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


public class DataBaseHandler extends SQLiteOpenHelper {

    public DataBaseHandler(Context context) {
        super(context, "RESTAURANT_MANAGER", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query= "CREATE TABLE USERS (ID INTEGER PRIMARY KEY, NAME TEXT, USERNAME TEXT UNIQUE, " +
                "EMAIL TEXT UNIQUE, PASSWORD TEXT)";
        sqLiteDatabase.execSQL(query);
        query= "CREATE TABLE SUPPLIERS (ID INTEGER PRIMARY KEY, NAME TEXT, PHONE_NUMBER TEXT)";
        sqLiteDatabase.execSQL(query);
        query="CREATE TABLE MENU( ID INTEGER PRIMARY KEY, NAME TEXT, PRICE DOUBLE)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public void addUser(ContentValues values) {
        SQLiteDatabase db=this.getWritableDatabase();
        db.insert("USERS",null,values);
        db.close();
    }


    public String userExists(String username, String password) {
        SQLiteDatabase db=this.getReadableDatabase();
        String query="SELECT NAME FROM USERS WHERE USERNAME='"+username+"' AND PASSWORD='"+password+"'";
        Cursor cr=db.rawQuery(query,null);
        if(cr.moveToFirst()) {
            return cr.getString(0);
        }
        return null;
    }

    public String userExists(String email) {
        SQLiteDatabase db=this.getReadableDatabase();
        String query="SELECT NAME FROM USERS WHERE EMAIL='"+email+"'";
        Cursor cr=db.rawQuery(query,null);
        if(cr.moveToFirst()) {
            return cr.getString(0);
        }
        return null;
    }

    public void updateUser(EditText email, EditText password) {
        SQLiteDatabase db=this.getWritableDatabase();
        String query="UPDATE USERS SET PASSWORD='"+password.getText().toString()+"' WHERE EMAIL='"+email.getText().toString()+"'";
        db.execSQL(query);
        db.close();
    }

    public void AddSupplier(Supplier supplier){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("NAME",supplier.name);
        values.put("PHONE_NUMBER",supplier.phone);
        db.insert("SUPPLIERS",null,values);
        db.close();
    }

    public void AddMenuItem(MenuItem item){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("NAME",item.name);
        values.put("PRICE",item.price);
        db.insert("MENU",null,values);
        db.close();
    }

    public List<MenuItem> getMenu() {
        SQLiteDatabase db=this.getReadableDatabase();
        String query="SELECT * FROM MENU";
        Cursor cr=db.rawQuery(query,null);
        cr.moveToFirst();
        List<MenuItem> menu=new ArrayList<>();
        do{
            if(cr.getCount()>0){
            MenuItem menuItem=new MenuItem();
            menuItem.setName(cr.getString(1));
            menuItem.setPrice(cr.getDouble(2));
            menu.add(menuItem);}
        }while (cr.moveToNext());
        return menu;
    }

    public List<Supplier> getSuppliers(){
        SQLiteDatabase db=this.getReadableDatabase();
        String query="SELECT * FROM SUPPLIERS";
        Cursor cr=db.rawQuery(query,null);
        cr.moveToFirst();
        List<Supplier> suppliers=new ArrayList<>();
        do{
            if(cr.getCount()>0) {
                Supplier supplier = new Supplier(cr.getString(1), cr.getString(2));
                suppliers.add(supplier);
            }

        }while (cr.moveToNext());
        return suppliers;
    }

}
