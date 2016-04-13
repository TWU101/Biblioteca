package com.mm;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> library = new ArrayList<>();

    public int getLibrarySize() {
        return library.size();
    }

    public void addToLibrary(Book book) {
        library.add(book);
    }

    public ArrayList<Book> getAvailableBookList() {
        ArrayList<Book> availableBooks = new ArrayList<>();
        for (Book book : library) {
            if (!book.checkedOut){
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public ArrayList<Book> getCompleteLibrary() {
        return library;
    }

    public void checkOutBook(Book book) {
        book.checkOut();
    }
}
