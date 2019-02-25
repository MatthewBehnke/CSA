package com.me;

public class Item {

    private String name;
    private double price;
    private String description;
    private int quantity;

    public Item() {}

    public Item(String name, double price, String description, int quantity){
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
