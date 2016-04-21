package com.mm.utilities;

import java.util.List;

public class Printer {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printList(List list) {
        for (Object object : list) {
            System.out.println(object);
        }
    }

    public void printSeparator(){
        System.out.println("============================");
    }

    public void printBlankLine(){
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
    }

    public void printQuitInstructions() {
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
}