package com.mm.utilities;

import java.util.List;

public class Printer {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_CYAN = "\u001B[36m";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printList(List list) {
        for (Object object : list) {
            System.out.println(object);
        }
    }

    private void printSeparator(){
        System.out.println("============================");
    }

    private void printBlankLine(){
        System.out.println();
    }

    public void printEnumeratedList(List list) {
        int counter = 1;
        if (list.isEmpty())
            printMessage("Nothing here!");
        else{
            for (Object object : list) {
                System.out.println(counter + ") " + object);
                counter++;
            }
        }
    }

    public void printSuccesfulCheckoutMessage(){
        System.out.println("Thank you! Enjoy the book.");
    }

    public void printHeading(String message) {
        printBlankLine();
        printMessage(message);
        printSeparator();
    }

    public void printMainMenu() {
        printBlankLine();
        printMessage("Main Menu");
        printQuitInstructions();
        printSeparator();
    }


    public void printHeading(String message, boolean printBackInstructions) {
        printBlankLine();
        printMessage(message);
        printBackInstructions();
        printSeparator();
    }

    public void printSuccessfullReturnMessage() {
        System.out.println("Thank you for returning the book!");
    }

    public void printWelcome(){
        printMessage("Welcome!");
        printMessage("Type " + (char)27 + "[1mLOGIN" + (char)27 + "[0m to log in to the application. \nYou will need to log in to checkout or return items..");
    }

    private void printQuitInstructions() {
        printMessage("Type " + (char)27 + "[1mquit" + (char)27 + "[0m to exit the application.");
    }

    public void printBackInstructions() {
        printMessage("Type " + (char)27 + "[1mback" + (char)27 + "[0m to return to the previous menu.");
    }

    public void printCantGoBack() {
        printMessage("At highest level! Type" + (char)27 + "[1m quit" + (char)27 + "[0m to quit the application.");
    }

    public void printEnterOnlyNumbers() {
        printMessage("Please only input valid numbers, not letters.");
    }

    public void printEnterValidNumber() {
        printMessage("That is not a valid option.");
    }

    public void printEmptyList() {
        printMessage("Nothing here!");
    }

    public void printLoggedInInstructions(String id){
        printMessage(ANSI_CYAN + "Welcome " + id + "!" + ANSI_RESET);
        printMessage(ANSI_CYAN + "Type " + (char)27 + "[1mLOGOUT" + (char)27 + ANSI_CYAN + " to log out of your current session." + ANSI_RESET);
        printMessage(ANSI_CYAN + "Type " + (char)27 + "[1mINFO" + (char)27 + ANSI_CYAN + " to print out your user information." + ANSI_RESET);
    }

    public void printLoggedOut(String id){
        printMessage(ANSI_CYAN + id + " has been succesfully logged out." + ANSI_RESET);
    }
}