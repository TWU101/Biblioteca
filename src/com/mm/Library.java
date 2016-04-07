package com.mm;

import java.util.Arrays;
import java.util.List;

public class Library {


    private List<Book> bookList = Arrays.asList(
            new Book("Test-Driven Development")
    );

    public List<Book> getBookList() {
        return bookList;
    }
}