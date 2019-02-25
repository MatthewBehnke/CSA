package com.me;

public class Item {

    private String name;
    private double price;
    private String description;
    private int quantity;

    Item() {}

    public Item(String name, double price, String description, int quantity){
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }

    double getPrice() {
        return this.price;
    }

    void setPrice(double price) {
        this.price = price;
    }

    String getDescription() {
        return this.description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    int getQuantity() {
        return this.quantity;
    }

    void setQuantity(int quantity) {
        this.quantity = quantity;
    }



}
