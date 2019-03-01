package com.me;

import java.util.ArrayList;

public class Shopper {

    private String name;
    private int balance;
    private ArrayList<Item> cart;


    public Shopper(String name, int balance) {
        this.name = name;
        this.balance = balance;
        cart = new ArrayList<>();
    }

    @Override
    public String toString() {
        return name + " : " + balance;
    }

    
    public ArrayList<Item> getCart() { return cart; }

    public void setCart(ArrayList<Item> item) { this.cart = item; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
