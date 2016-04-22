package com.mm.models;

public class Book implements Checkoutable{

    private String title;
    private String author;
    private int yearPublished;
    private boolean checkedOut;

    public Book(String bookTitle, String bookAuthor, int bookYearPublished){
        title = bookTitle;
        author = bookAuthor;
        yearPublished = bookYearPublished;
        checkedOut = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void checkOutItem() {
        checkedOut = true;
    }

    @Override
    public String toString() {
        return title + " | " + author + " | " + yearPublished;
    }


    public void returnItem() {
        checkedOut = false;
    }

    public boolean isCheckedOut(){
        return checkedOut;
    }
}