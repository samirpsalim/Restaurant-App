package com.example.restaurantapp;

public class MenuItem {
    String name;
    double price;
    int id;

    public MenuItem(String name, double price){
        this.name=name;
        this.price=price;
    }

    public MenuItem() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
