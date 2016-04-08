package com.mm;

public class Book {

    private String title;

    public Book(String bookTitle){
        title = bookTitle;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}