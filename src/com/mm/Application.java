package com.mm;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Application {

    private ArrayList<Book> library = new ArrayList<>();
    private ArrayList mainMenu = new ArrayList();
    Printer printer = new Printer();

    public void setUp(){
        library.add(new Book("Java for Dummies", "John Smith", 2005));
        library.add(new Book("Agile Samurai", "Abe Lincoln", 1995));
        library.add(new Book("TDD By Example", "Kent Beck", 2007));
        library.add(new Book("Harry Potter", "JK Rowling", 2005));

        mainMenu.add("1) List Books");
        mainMenu.add("2) Quit");
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
        printer.printMessage("");
        printer.printMessage("Main Menu");
        printer.printSeperator();
        printer.printList(mainMenu);
    }

    class InputHandler {

        public int getUserInput(Scanner input) {
            try {
                return input.nextInt();
            } catch (InputMismatchException e) {
                input.next();
                return -1;
            }
        }

        public boolean getOption(int userSelectedMenuOption, Scanner scanner) {
            boolean continueAskingForUserInput = true;
            switch (userSelectedMenuOption) {
                case -1:
                    System.out.println("Please only input valid numbers, not letters.");
                    return continueAskingForUserInput;
                case 1:
                    printBookList();
                    return continueAskingForUserInput;
                case 2:
                    System.out.println("BYE BYE");
                    continueAskingForUserInput = false;
                    return continueAskingForUserInput;
                default:
                    System.out.println("Sorry, that is not a valid option :(");
                    return continueAskingForUserInput;
            }
        }
    }
}