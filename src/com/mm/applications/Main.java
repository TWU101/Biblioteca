package com.mm.applications;

public class Main {

    public static void main(String[] args) {
        Application application = new Application();

        application.setUp();
        application.printWelcome();

        application.execute();
    }
}
