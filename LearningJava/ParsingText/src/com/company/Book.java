package com.company;

public class Book {
    private String title;
    private int rating;
    private double price;
    private boolean favorite;

    public Book(String title, double price, int rating, boolean favorite) {
        this.title = title;
        this.price = price;
        this.rating = rating;
        this.favorite = favorite;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getFavorit() {
        return favorite;
    }

    public void addFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}