package com.mm.applications;

import com.mm.utilities.IOHandler;
import com.mm.utilities.Printer;

public class Main {

    public static void main(String[] args) {
        boolean continueAskingForUserInput = true;
        Application application = new Application();
        Printer printer = new Printer();
        IOHandler iOHandler = new IOHandler(application, printer);

        application.setUp();
        application.printWelcome();

        while (continueAskingForUserInput) {
            application.printMainMenu();
            int userSelectedMenuOption = iOHandler.getUserInput();
            continueAskingForUserInput = iOHandler.performSelectedMenuOption(userSelectedMenuOption);
        }

    }
}
