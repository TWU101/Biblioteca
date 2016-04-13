package com.mm.applications;

import com.mm.utilities.InputHandler;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean continueAskingForUserInput = true;
        Scanner readUserInput = new Scanner(System.in);
        Application application = new Application();
        InputHandler inputHandler = new InputHandler(application);

        application.setUp();
        application.printWelcome();

        while (continueAskingForUserInput) {
            application.printMainMenu();
            int userSelectedMenuOption = inputHandler.getUserInput(readUserInput);
            continueAskingForUserInput = inputHandler.performSelectedMenuOption(userSelectedMenuOption);
        }

    }
}
