package com.mm.utilities;

import java.util.List;
import java.util.Scanner;

public class IOHandler {

    private Scanner scanner;
    private Printer printer;

    public IOHandler(Printer printer) {
        scanner = new Scanner(System.in);
        this.printer = printer;
    }

    public int getUserInput() {
        String userInputString = scanner.next();

        if (("q".equalsIgnoreCase(userInputString)) || ("quit").equalsIgnoreCase(userInputString)){
            return MenuOption.QUIT_OPTION;
        }
        if (("b".equalsIgnoreCase(userInputString)) || ("back").equalsIgnoreCase(userInputString)){
            return MenuOption.BACK_OPTION;
        }

        try {
            return Integer.parseInt(userInputString);
        } catch (NumberFormatException e) {
            return MenuOption.INVALID_OPTION;
        }
    }

    public int retrieveMainMenuOption(List mainMenu) {
        printer.printMainMenu();
        printer.printEnumeratedList(mainMenu);
        return getUserInput();
    }

    public int retrieveSelectedItemFromList(String checkoutOrReturn, List bookList) {
        final boolean INCLUDE_BACK_INSTRUCTIONS = true;
        final int LIST_IS_EMPTY = 0;
        printer.printHeading("Select the Number Of The Book To " + checkoutOrReturn, INCLUDE_BACK_INSTRUCTIONS);
        printer.printEnumeratedList(bookList);
        int maxSize = bookList.size();

        if (maxSize == LIST_IS_EMPTY) {
            return MenuOption.BACK_OPTION;
        }

        int userSelectedOption = getUserInput();

        if ((userSelectedOption > maxSize) || (userSelectedOption == MenuOption.INVALID_OPTION)){
            printer.printEnterValidNumber();
            userSelectedOption = retrieveSelectedItemFromList(checkoutOrReturn, bookList);
        }

        return userSelectedOption;

    }
}
