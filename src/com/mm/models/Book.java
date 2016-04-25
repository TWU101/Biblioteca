package com.mm.models;

public class Book implements Checkoutable{

    private String title;
    private String author;
    private int yearPublished;
    private boolean checkedOut;
    private User itemOwner;

    public Book(String bookTitle, String bookAuthor, int bookYearPublished){
        this.title = bookTitle;
        this.author = bookAuthor;
        this.yearPublished = bookYearPublished;
        this.checkedOut = false;
        this.itemOwner = null;
    }

    @Override
    public String toString() {
        return title + " | " + author + " | " + yearPublished;
    }

    public void checkOutItem(User user) {
        checkedOut = true;
        itemOwner = user;
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