package com.mm;

import java.util.ArrayList;


public class Application {

    private ArrayList<Book> library = new ArrayList<>();
    Printer printer = new Printer();

    public void setUp(){
        library.add(new Book("Java for Dummies", "John Smith", 2005));
        library.add(new Book("Agile Samurai", "Abe Lincoln", 1995));
        library.add(new Book("TDD By Example", "Kent Beck", 2007));
        library.add(new Book("Harry Potter", "JK Rowling", 2005));
    }

    public ArrayList<Book> getLibrary() {
        return library;
    }

    public void printWelcome() {
        printer.printMessage("Welcome!");
        printer.printSeperator();
    }

    public void printBookList(){
        printer.printList(library);
    }
}