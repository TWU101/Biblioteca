package com.mm;

public class Printer {
    Application application = new Application();
    Library library = new Library();

    public void printWelcome() {
        System.out.println("Welcome!");
    }

    public void printMenu(){
        System.out.println("Application Options:");
        for (String option : application.getMenuOptions()) {
            System.out.println(option);
        }
    }

    public void printBookList() {
        System.out.println("\nBook list:");
        for (Book book : library.getBookList()) {
            System.out.println(book.getTitle());
        }
    }
}