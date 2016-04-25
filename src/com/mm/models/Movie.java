package com.mm.models;

public class Movie implements Checkoutable {
    private String name;
    private int year;
    private String director;
    private String rating;
    private boolean checkedOut;
    private User itemOwner;

    public Movie(String name, int year, String director, String rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.checkedOut = false;
        this.itemOwner = null;
    }

    @Override
    public String toString() {
        return name + " | " + year + " | " + director + " | " + rating;
    }

    public void checkOutItem(User user){
        checkedOut = true;
        this.itemOwner = user;
    }

    public void returnItem(User user){
        checkedOut = false;
        itemOwner = null;
    }

    public boolean isCheckedOut(){
        return checkedOut;
    }

    public User getOwner() {
        return itemOwner;
    }
}
