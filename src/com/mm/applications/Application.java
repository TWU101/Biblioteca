package com.mm.applications;

import com.mm.models.Book;
import com.mm.models.Library;
import com.mm.utilities.IOHandler;
import com.mm.utilities.MenuOption;
import com.mm.utilities.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Application {
    private Library library = new Library();
    private ArrayList mainMenu = new ArrayList();
    private Printer printer = new Printer();
    private Scanner readUserInput = new Scanner(System.in);
    private IOHandler iOHandler = new IOHandler(this, printer);
    private final static int INDEX_OFFSET = 1;


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


    public void printMainMenu() {
        printer.printMainMenu();
        printer.printEnumeratedList(mainMenu);
    }

    public boolean checkOutBook() {
        int maxSize = getAvailableBookList().size();
        int selectedOption = iOHandler.getBookToCheckOut();

        if (selectedOption == MenuOption.BACK_OPTION) {
            return true;
        } else if (selectedOption == MenuOption.QUIT_OPTION) {
            return false;
        } else if (selectedOption == MenuOption.INVALID_OPTION){
            printer.printerEnterOnlyNumbers();
            return true;
        } else if (selectedOption > maxSize) {
            printer.printEnterValidNumber();
            return true;
        }


        int bookIndexToCheckOut = selectedOption - INDEX_OFFSET;
        library.checkOutBook(bookIndexToCheckOut);
        return true;
    }


    public boolean returnBook() {
        int maxSize = getCheckedOutBookList().size();
        int selectedOption = iOHandler.getBookToReturn();

        if (selectedOption == MenuOption.BACK_OPTION) {
            return true;
        } else if (selectedOption == MenuOption.QUIT_OPTION) {
            return false;
        } else if (selectedOption == MenuOption.INVALID_OPTION){
            printer.printerEnterOnlyNumbers();
            return true;
        } else if (selectedOption > maxSize) {
            printer.printEnterValidNumber();
            return true;
        }

        int bookIndexToReturn = selectedOption - INDEX_OFFSET;
        library.returnBook(bookIndexToReturn);
        return true;
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