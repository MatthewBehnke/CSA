package com.me;

import java.util.ArrayList;

public class Shopper {

    private String name;
    private double balance;
    private ArrayList<Item> cart;
    private double cost;

    public Shopper(String name, double balance) {
        this.name = name;
        this.balance = balance;
        cart = new ArrayList<>();
    }

    @Override
    public String toString() {
        return name + " : " + balance;
    }

    public void buy(ArrayList<Item> availableItems, Item item) {
        int index = availableItems.indexOf(item);
        availableItems.get(index).setQuantity(availableItems.get(index).getQuantity() - 1);
        cart.add(item);
    }

    public double calculateCost() {
        cart.forEach(n ->
                cost = cost + n.getPrice()
        );
        return cost;
    }

    public ArrayList<Item> getCart() { return cart; }

    public void setCart(ArrayList<Item> item) { this.cart = item; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
