package com.mm;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean continueAskingForUserInput = true;
        Scanner readUserInput = new Scanner(System.in);
        Application application = new Application();
        Application.InputHandler inputHandler = application.new InputHandler();

        application.setUp();
        application.printWelcome();

        while (continueAskingForUserInput) {
            application.printMainMenu();
            int userSelectedMenuOption = inputHandler.getUserInput(readUserInput);
            continueAskingForUserInput = inputHandler.getOption(userSelectedMenuOption, readUserInput);
        }

    }
}
