package com.mm.applications;

import com.mm.utilities.InputHandler;
import com.mm.utilities.Printer;
import com.mm.models.Book;
import com.mm.models.Library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Application {
    Library library = new Library();
    private ArrayList mainMenu = new ArrayList();
    Printer printer = new Printer();
    Scanner readUserInput = new Scanner(System.in);
    InputHandler inputHandler = new InputHandler(this, printer);


    public void setUp(){
        library.addToLibrary(new Book("Java for Dummies", "John Smith", 2005));
        library.addToLibrary(new Book("Agile Samurai", "Abe Lincoln", 1995));
        library.addToLibrary(new Book("TDD By Example", "Kent Beck", 2007));
        library.addToLibrary(new Book("Harry Potter", "JK Rowling", 2005));

        mainMenu.add("List All Books");
        mainMenu.add("Checkout Book");
        mainMenu.add("Return Book");
    }

    public void printWelcome() {
        printer.printWelcome();
    }


    public void printMainMenu(){
        printer.printHeading("Main Menu");
        printer.printEnumeratedList(mainMenu);
    }

    public void checkOutBook(){
        inputHandler.performCheckoutBookOperation(library);
    }


    public void returnBook() {
        inputHandler.performReturnBookOperation(library);
    }

    public List<Book> getAvailableBookList() {
        return library.getAvailableBookList();
    }

    public List<Book> getCompleteLibrary() {
        return library.getCompleteLibrary();
    }

    public void printCompleteLibrary() {
        printer.printList(getCompleteLibrary());
    }

    public int getLibrarySize() {
        return library.getLibrarySize();
    }

    public List getCheckedOutBookList() {
        return library.getCheckedOutBookList();
    }
}