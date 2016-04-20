package com.mm.models;

public class Movie {
    private String name;
    private int year;
    private String director;
    private String rating;
    private boolean checkedOut;

    public Movie(String name, int year, String director, String rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.checkedOut = false;
    }

    @Override
    public String toString() {
        return name + " | " + year + " | " + director + " | " + rating;
    }

    public void checkOutMovie(){
        checkedOut = true;
    }

    public void returnMovie(){
        checkedOut = false;
    }
}
