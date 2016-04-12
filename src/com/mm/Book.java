package com.mm;

public class Book {

    private String title;
    private String author;
    private int yearPublished;
    boolean checkedOut;

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


    @Override
    public String toString() {
        return title + " | " + author + " | " + yearPublished;
    }

    public void checkOut() {
        checkedOut = true;
    }
}