package com.mm;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {

    Application application;
    Printer printer = new Printer();

    public InputHandler(Application application) {
        this.application = application;
    }

    public int getUserInput(Scanner input) {
            try {
                return input.nextInt();
            } catch (InputMismatchException e) {
                input.next();
                return -1;
            }
        }

    public boolean getOption(int userSelectedMenuOption) {
            boolean continueAskingForUserInput = true;
            switch (userSelectedMenuOption) {
                case -1:
                    printer.printMessage("Please only input valid numbers, not letters.");
                    return continueAskingForUserInput;
                case 1:
                    application.printAvailableBookList();
                    return continueAskingForUserInput;
                case 2:
                    application.printAvailableBookList();
                    printer.printMessage("CHECKOUT BOOK OPTION SELECTED");
                    return continueAskingForUserInput;
                case 3:
                    printer.printMessage("BYE BYE");
                    continueAskingForUserInput = false;
                    return continueAskingForUserInput;
                default:
                    printer.printMessage("Sorry, that is not a valid option :(");
                    return continueAskingForUserInput;
            }
        }
}
