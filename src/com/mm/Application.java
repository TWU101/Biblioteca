package com.mm;

import java.util.ArrayList;


public class Application {
    Library library = new Library();
    private ArrayList mainMenu = new ArrayList();
    Printer printer = new Printer();
    InputHandler inputHandler = new InputHandler(this);

    public void setUp(){
        library.addToLibrary(new Book("Java for Dummies", "John Smith", 2005));
        library.addToLibrary(new Book("Agile Samurai", "Abe Lincoln", 1995));
        library.addToLibrary(new Book("TDD By Example", "Kent Beck", 2007));
        library.addToLibrary(new Book("Harry Potter", "JK Rowling", 2005));

        mainMenu.add("1) List Books");
        mainMenu.add("2) Checkout Book");
        mainMenu.add("3) Quit");
    }

    public void printWelcome() {
        printer.printMessage("Welcome!");
    }


    public void printMainMenu(){
        printer.printBlankLine();
        printer.printMessage("Main Menu");
        printer.printSeperator();
        printer.printList(mainMenu);
    }

    public void checkOutBook() {

    }

    public void printAvailableBookList() {
        printer.printList(library.getAvailableBookList());
    }

    public ArrayList<Book> getCompleteLibrary() {
        return library.getCompleteLibrary();
    }

    public void printCompleteLibrary() {
        printer.printList(getCompleteLibrary());
    }

    public int getLibrarySize() {
        return library.getLibrarySize();
    }
}