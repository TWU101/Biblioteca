package com.mm.utilities;

import com.mm.applications.Application;

import java.util.Scanner;

public class InputHandler {

    Application application;
    Printer printer = new Printer();

    public InputHandler(Application application) {
        this.application = application;
    }

    public int getUserInput(Scanner input) {
        String inputStr = input.nextLine();

            try {
                return Integer.parseInt(inputStr);
            } catch (NumberFormatException e) {
                if (("q".equalsIgnoreCase(inputStr)) || ("quit").equalsIgnoreCase(inputStr)){
                    return -2;
                }
                if (("b".equalsIgnoreCase(inputStr)) || ("back").equalsIgnoreCase(inputStr)){
                    return -3;
                }
                return -1;
            }
        }

    public boolean performSelectedMenuOption(int userSelectedMenuOption) {
            boolean continueAskingForUserInput = true;
            switch (userSelectedMenuOption) {
                case -3:
                    printer.printMessage("At highest level! Type" + (char)27 + "[1m quit" + (char)27 + "[0m to quit the application.");
                    return continueAskingForUserInput;
                case -2:
                    printer.printMessage("BYE BYE");
                    continueAskingForUserInput = false;
                    return continueAskingForUserInput;
                case -1:
                    printer.printMessage("Please only input valid numbers, not letters.");
                    return continueAskingForUserInput;
                case 1:
                    application.printCompleteLibrary();
                    return continueAskingForUserInput;
                case 2:
                    application.checkOutBook();
                    return continueAskingForUserInput;
                case 3:
                   application.returnBook();
                    return continueAskingForUserInput;
                default:
                    printer.printMessage("Sorry, that is not a valid option :(");
                    return continueAskingForUserInput;
            }
        }
}
