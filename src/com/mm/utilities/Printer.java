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

    public void printSeperator(){
        System.out.println("============================");
    }

    public void printBlankLine(){
        System.out.println();
    }

    public void printEnumeratedList(List list) {
        int counter = 1;
        for (Object object : list) {
            System.out.println(counter + ") " + object);
            counter++;
        }
    }

    public void printSuccesfulCheckoutMessage(){
        System.out.println("Thank you! Enjoy the book.");
    }

    public void printHeading(String message) {
        printBlankLine();
        printMessage(message);
        printSeperator();
    }

    public void printSuccessfullReturnMessage() {
        System.out.println("Book successfully returned!");
    }
}