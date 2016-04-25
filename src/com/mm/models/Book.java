package com.mm.models;

public class Book implements Checkoutable{

    private String title;
    private String author;
    private int yearPublished;
    private boolean checkedOut;
    private User itemOwner;

    public Book(String bookTitle, String bookAuthor, int bookYearPublished){
        title = bookTitle;
        author = bookAuthor;
        yearPublished = bookYearPublished;
        checkedOut = false;
        itemOwner = null;
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

    public void checkOutItem(User user) {
        checkedOut = true;
        itemOwner = user;
    }

    @Override
    public String toString() {
        return title + " | " + author + " | " + yearPublished;
    }


    public void returnItem(User user) {
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