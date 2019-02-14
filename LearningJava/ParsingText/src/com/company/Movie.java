package com.company;

public class Movie {
    private String title;
    private int rating;
    private double price;

    public Movie(String title, int rating, double price) {
            this.title = title;
            this.rating = rating;
            this.price = price;
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
}
