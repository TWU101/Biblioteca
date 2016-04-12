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

    public ArrayList printAvailableBookList() {
        return null;
    }

    public ArrayList<Book> getCompleteLibrary() {
        return library;
    }

    public void checkOutBook(Book book) {
        book.checkOut();
    }
}
