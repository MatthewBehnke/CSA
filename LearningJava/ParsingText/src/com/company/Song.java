package com.company;

public class Song {
    private String title;
    private String author;
    private int rating;
    private double price;

    public Song() {
        this.title = "";
        this.author = "";
        this.price = 0;
        this.rating = 0;
    }

    public Song(String title, String author, double price, int rating) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
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
