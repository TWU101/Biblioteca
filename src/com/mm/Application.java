package com.mm;

import java.util.ArrayList;


public class Application {

    private ArrayList<Book> library = new ArrayList<>();
    Printer printer = new Printer();

    public void setUp(){
        library.add(new Book("Java for Dummies"));
        library.add(new Book("Agile Samurai"));
        library.add(new Book("TDD By Example"));
        library.add(new Book("Harry Potter"));
    }

    public void printWelcome() {
        printer.printMessage("Welcome!");
    }

    public void printBookList(){
        printer.printList(library);
    }
}