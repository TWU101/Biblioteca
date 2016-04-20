package com.mm.utilities;

import com.mm.applications.Application;

import java.util.Scanner;

public class IOHandler {

    private Application application;
    private Scanner scanner;
    private Printer printer;

    public IOHandler(Application application, Printer printer) {
        this.application = application;
        scanner = new Scanner(System.in);
        this.printer = printer;
    }

    public int getUserInput() {
        String userInputString = scanner.next();
        try {
            return Integer.parseInt(userInputString);
        } catch (NumberFormatException e) {
            if (("q".equalsIgnoreCase(userInputString)) || ("quit").equalsIgnoreCase(userInputString)){
                return MenuOption.QUIT_OPTION;
            }
            if (("b".equalsIgnoreCase(userInputString)) || ("back").equalsIgnoreCase(userInputString)){
                return MenuOption.BACK_OPTION;
            }
            return MenuOption.INVALID_OPTION;
        }
    }

    public boolean performSelectedMenuOption(int userSelectedMenuOption) {
        boolean continueAskingForUserInput = true;
        switch (userSelectedMenuOption) {
            case MenuOption.BACK_OPTION:
                printer.printCantGoBack();
                return continueAskingForUserInput;
            case MenuOption.INVALID_OPTION:
                printer.printerEnterOnlyNumbers();
                return continueAskingForUserInput;
            case MenuOption.QUIT_OPTION:
                printer.printMessage("BYE BYE");
                continueAskingForUserInput = false;
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
                printer.printEnterValidNumber();
                return continueAskingForUserInput;
        }
    }

    public int getBookToCheckOut(){
        final int SELECTION_OFFSET = 0;
        final boolean INCLUDE_BACK_INSTRUCTIONS = true;

        printer.printHeading("Select the Number Of The Book To Checkout", INCLUDE_BACK_INSTRUCTIONS);
        printer.printEnumeratedList(application.getAvailableBookList());

        if (application.getAvailableBookList().size() ==0) {
            return MenuOption.BACK_OPTION;
        }
        int userSelectedMenuOption = getUserInput();
        int userSelectedBookToCheckout = userSelectedMenuOption - SELECTION_OFFSET;

        if (userSelectedMenuOption == MenuOption.BACK_OPTION) {
            return MenuOption.BACK_OPTION;
        }
        else if (userSelectedMenuOption == MenuOption.QUIT_OPTION) {
            printer.printerEnterOnlyNumbers();
            return MenuOption.QUIT_OPTION;
        }
        else{
           return userSelectedBookToCheckout;
        }
    }

    public int getBookToReturn() {
        final int SELECTION_OFFSET = 0;
        final boolean INCLUDE_BACK_INSTRUCTIONS = true;

        printer.printHeading("Select the Number Of The Book To Return", INCLUDE_BACK_INSTRUCTIONS);
        printer.printEnumeratedList(application.getCheckedOutBookList());

        int userSelectedMenuOption = getUserInput();
        int userSelectedBookToReturn = userSelectedMenuOption - SELECTION_OFFSET;

        if (userSelectedMenuOption == MenuOption.BACK_OPTION) {
            return MenuOption.BACK_OPTION;
        }
        else if (userSelectedMenuOption == MenuOption.QUIT_OPTION) {
            printer.printerEnterOnlyNumbers();
            return MenuOption.QUIT_OPTION;
        }
        else if (userSelectedMenuOption > application.getCheckedOutBookList().size()) {
            printer.printEnterValidNumber();
            return -1;
        }
        else{
            return userSelectedBookToReturn;
        }
    }
}
