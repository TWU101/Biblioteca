package com.mm.applications;

import com.mm.models.Book;
import com.mm.models.Library;
import com.mm.utilities.IOHandler;
import com.mm.utilities.MenuOption;
import com.mm.utilities.Printer;

import java.util.ArrayList;
import java.util.List;


public class Application {
    private Library library;
    private ArrayList mainMenu;
    private Printer printer;
    private IOHandler ioHandler;
    private final static int INDEX_OFFSET = 1;

    public Application() {
        this.library = new Library();
        this.mainMenu = new ArrayList();
        this.printer = new Printer();
        this.ioHandler = new IOHandler(printer);
    }

    public void setUp(){
        library.addToLibrary(new Book("Java for Dummies", "John Smith", 2005));
        library.addToLibrary(new Book("Agile Samurai", "Abe Lincoln", 1995));
        library.addToLibrary(new Book("TDD By Example", "Kent Beck", 2007));
        library.addToLibrary(new Book("Harry Potter", "JK Rowling", 2005));

        mainMenu.add("List All Books");
        mainMenu.add("Checkout Book");
        mainMenu.add("Return Book");
    }

    public void execute() {
        setUp();
        printWelcome();
        loopMainMenu();
    }

    public void printWelcome() {
        printer.printWelcome();
    }

    public void loopMainMenu() {
        int userSelectedMenuOption = ioHandler.retrieveMainMenuOption(mainMenu);
        boolean continueLooping = true;

        switch (userSelectedMenuOption) {
            case MenuOption.BACK_OPTION:
                printer.printCantGoBack();
                break;
            case MenuOption.INVALID_OPTION:
                printer.printEnterOnlyNumbers();
                break;
            case MenuOption.QUIT_OPTION:
                printer.printMessage("BYE BYE");
                return;
            case 1:
                printCompleteLibrary();
                break;
            case 2:
                continueLooping = checkOutBook();
                break;
            case 3:
                continueLooping = returnBook();
                break;
            default:
                printer.printEnterValidNumber();
                break;
        }
        if (!continueLooping) return;
        loopMainMenu();
    }

    public boolean checkOutBook() {
        int selectedOption = ioHandler.retrieveBookOption("Checkout", getAvailableBookList());

        if (selectedOption == MenuOption.BACK_OPTION) {
            return true;
        } else if (selectedOption == MenuOption.QUIT_OPTION) {
            printer.printMessage("BYEBYE");
            return false;
        } else if (selectedOption == MenuOption.INVALID_OPTION){
            printer.printEnterOnlyNumbers();
            return true;
        }

        int bookIndexToCheckOut = selectedOption - INDEX_OFFSET;
        library.checkOutBook(bookIndexToCheckOut);
        printer.printSuccesfulCheckoutMessage();
        return true;
    }

    public boolean returnBook() {
        int selectedOption = ioHandler.retrieveBookOption("Return", getCheckedOutBookList());

        if (selectedOption == MenuOption.BACK_OPTION) {
            return true;
        } else if (selectedOption == MenuOption.QUIT_OPTION) {
            printer.printMessage("BYEBYE");
            return false;
        } else if (selectedOption == MenuOption.INVALID_OPTION){
            printer.printEnterOnlyNumbers();
            return true;
        }

        int bookIndexToReturn = selectedOption - INDEX_OFFSET;
        library.returnBook(bookIndexToReturn);
        printer.printSuccessfullReturnMessage();
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

    public List getCheckedOutBookList() {
        return library.getCheckedOutBookList();
    }
}