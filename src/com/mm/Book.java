package com.mm;

public class Book{

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

    public void checkOut() {
        checkedOut = true;
    }

    @Override
    public String toString() {
        return title + " | " + author + " | " + yearPublished;
    }

    @Override
    public boolean equals(Object otherBook) {
        if (this == otherBook) return true;
        if (!(otherBook instanceof Book)) return false;

        Book book = (Book)otherBook;
        return
                ( this.title == book.title ) &&
                        ( this.author == book.author ) &&
                        ( this.yearPublished == book.yearPublished );
    }
}