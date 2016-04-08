package com.mm;

import java.util.ArrayList;


public class Application {

    private ArrayList<Book> library = new ArrayList<>();
    Printer printer = new Printer();

    public void printWelcome() {
        printer.printMessage("Welcome!");
    }
}