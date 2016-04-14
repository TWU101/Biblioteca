package com.mm.applications;

import com.mm.utilities.InputHandler;
import com.mm.utilities.Printer;

public class Main {

    public static void main(String[] args) {
        boolean continueAskingForUserInput = true;
        Application application = new Application();
        Printer printer = new Printer();
        InputHandler inputHandler = new InputHandler(application, printer);

        application.setUp();
        application.printWelcome();

        while (continueAskingForUserInput) {
            application.printMainMenu();
            int userSelectedMenuOption = inputHandler.getUserInput();
            continueAskingForUserInput = inputHandler.performSelectedMenuOption(userSelectedMenuOption);
        }

    }
}
