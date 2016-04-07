package com.mm;

public class Printer {
    Menu menu = new Menu();
    Library library = new Library();

    public void printWelcome() {
        System.out.println("Welcome!");
    }

    public void printMenu(){
        System.out.println("Menu Options:");
        for (String option : menu.getMenuOptions()) {
            System.out.println(option);
        }
    }

    public void printBookList() {
        System.out.println("\nBook list:");
        for (Book book : library.getBookList()) {
            System.out.println(book.getName());
        }
    }
}