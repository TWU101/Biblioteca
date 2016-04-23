package com.mm.applications;

import com.mm.models.*;
import com.mm.utilities.IOHandler;
import com.mm.utilities.MenuOption;
import com.mm.utilities.Printer;

import java.util.ArrayList;
import java.util.List;


public class Application {
    private Library bookLibrary;
    private Library movieLibrary;
    private User currentUser;
    private ArrayList <User> userList;
    private ArrayList mainMenu;
    private Printer printer;
    private IOHandler ioHandler;
    private final static int INDEX_OFFSET = 1;

    public Application() {
        this.bookLibrary = new Library();
        this.movieLibrary = new Library();
        this.mainMenu = new ArrayList();
        this.printer = new Printer();
        this.ioHandler = new IOHandler(printer);
        userList = new ArrayList<>();
        this.currentUser = null;
    }

    public void setUp(){
        bookLibrary.addToLibrary(new Book("Java for Dummies", "John Smith", 2005));
        bookLibrary.addToLibrary(new Book("Agile Samurai", "Abe Lincoln", 1995));
        bookLibrary.addToLibrary(new Book("TDD By Example", "Kent Beck", 2007));
        bookLibrary.addToLibrary(new Book("Harry Potter", "JK Rowling", 2005));

        movieLibrary.addToLibrary(new Movie("Die Hard", 1988, "John McTiernan", "8"));
        movieLibrary.addToLibrary(new Movie("Deadpool", 2016, "Tim Miller", "9"));
        movieLibrary.addToLibrary(new Movie("Guardians of the Galaxy", 2014, "James Gunn", "7"));
        movieLibrary.addToLibrary(new Movie("Up", 2009, "Pete Docter", "9"));

        userList.add(new User("123-4567", "password"));
        userList.add(new User("000-1111", "zeroone"));
        userList.add(new User("987-6543", "ninesix"));
        userList.add(new User("111-2222", "onetwo"));

        mainMenu.add("List All Books and Movies");
        mainMenu.add("Checkout Book");
        mainMenu.add("Return Book");
        mainMenu.add("Checkout Movie");
        mainMenu.add("Return Movie");
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
            case MenuOption.LOGIN_OPTION:
                login();
                break;
            case MenuOption.LOGOUT_OPTION:
                logout();
                break;
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
                continueLooping = checkOutItem(bookLibrary, "Book");
                break;
            case 3:
                continueLooping = returnItem(bookLibrary, "Book");
                break;
            case 4:
                continueLooping = checkOutItem(movieLibrary, "Movie");
                break;
            case 5:
                continueLooping = returnItem(movieLibrary, "Movie");
                break;
            default:
                printer.printEnterValidNumber();
                break;
        }
        if (!continueLooping) return;
        loopMainMenu();
    }

    private void login() {
        if (currentUser != null) {
            printer.printMessage("Someone is already logged in!");
            return;
        }

        String inputUsername = ioHandler.getString("Please enter your username");
        String inputPassword = ioHandler.getString("Please enter your password");
        User userToCompareAgainst = new User(inputUsername, inputPassword);

        int currentUserIndex = userList.indexOf(userToCompareAgainst);
        if (currentUserIndex != -1) {
            currentUser = userList.get(currentUserIndex);
        }
        printer.printLoggedInInstructions(currentUser.id);

    }

    private void logout() {
        if (currentUser != null) {
            String currentID = currentUser.getID();
            currentUser = null;
            printer.printLoggedOut(currentID);
        } else {
            printer.printMessage("No one is currently logged in.");
        }
    }

    public boolean checkOutItem(Library library, String itemType) {
        int selectedOption = ioHandler.retrieveSelectedItemFromList("Checkout", library.getAvailableItemList(), itemType);

        if (selectedOption == MenuOption.BACK_OPTION) {
            System.out.println(selectedOption);
            return true;
        } else if (selectedOption == MenuOption.QUIT_OPTION) {
            printer.printMessage("BYEBYE");
            return false;
        }

        int itemIndexToCheckout = selectedOption - INDEX_OFFSET;
        library.checkOutItem(itemIndexToCheckout);
        printer.printSuccesfulCheckoutMessage();
        return true;
    }

    public boolean returnItem(Library library, String itemType) {
        int selectedOption = ioHandler.retrieveSelectedItemFromList("Return", library.getCheckedOutItemList(), itemType);

        if (selectedOption == MenuOption.BACK_OPTION) {
            return true;
        } else if (selectedOption == MenuOption.QUIT_OPTION) {
            printer.printMessage("BYEBYE");
            return false;
        }

        int bookIndexToReturn = selectedOption - INDEX_OFFSET;
        bookLibrary.returnItem(bookIndexToReturn);
        printer.printSuccessfullReturnMessage();
        return true;
    }

    public List<Checkoutable> getCompleteLibrary(Library library) {
        return library.getCompleteLibrary();
    }

    public void printCompleteLibrary() {
        printer.printHeading("Books");
        printer.printList(getCompleteLibrary(bookLibrary));
        printer.printHeading("Movies");
        printer.printList(getCompleteLibrary(movieLibrary));
    }

}