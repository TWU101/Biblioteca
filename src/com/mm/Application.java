package com.mm;

import java.util.ArrayList;


public class Application {

    private ArrayList<Book> library = new ArrayList<>();
    private ArrayList mainMenu = new ArrayList();
    Printer printer = new Printer();
    InputHandler inputHandler = new InputHandler(this);

    public void setUp(){
        library.add(new Book("Java for Dummies", "John Smith", 2005));
        library.add(new Book("Agile Samurai", "Abe Lincoln", 1995));
        library.add(new Book("TDD By Example", "Kent Beck", 2007));
        library.add(new Book("Harry Potter", "JK Rowling", 2005));

        mainMenu.add("1) List Books");
        mainMenu.add("2) Checkout Book");
        mainMenu.add("3) Quit");
    }

    public ArrayList<Book> getLibrary() {
        return library;
    }

    public void printWelcome() {
        printer.printMessage("Welcome!");
    }

    public void printBookList(){
        printer.printList(library);
    }

    public void printMainMenu(){
        printer.printBlankLine();
        printer.printMessage("Main Menu");
        printer.printSeperator();
        printer.printList(mainMenu);
    }

}