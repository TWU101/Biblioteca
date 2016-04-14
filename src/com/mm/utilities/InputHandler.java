package com.mm.utilities;

import com.mm.applications.Application;
import com.mm.models.Book;
import com.mm.models.Library;

import java.util.Scanner;

public class InputHandler {

    private Application application;
    private Scanner scanner;
    private Printer printer;

    public InputHandler(Application application, Printer printer) {
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
                return 0;
            }
            if (("b".equalsIgnoreCase(userInputString)) || ("back").equalsIgnoreCase(userInputString)){
                return -2;
            }
            return -1;
        }
    }

    public boolean performSelectedMenuOption(int userSelectedMenuOption) {
        boolean continueAskingForUserInput = true;
        switch (userSelectedMenuOption) {
            case -2:
                printer.printCantGoBack();
                return continueAskingForUserInput;
            case -1:
                printer.printerEnterOnlyNumbers();
                return continueAskingForUserInput;
            case 0:
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
                printer.printMessage("Sorry, that is not a valid option :(");
                return continueAskingForUserInput;
        }
    }

    public void performCheckoutBookOperation(Library library){
        final int SELECTION_OFFSET = 1;
        final boolean INCLUDE_BACK_INSTRUCTIONS = true;

        printer.printHeading("Select the Number Of The Book To Checkout", INCLUDE_BACK_INSTRUCTIONS);
        printer.printEnumeratedList(application.getAvailableBookList());
        int userSelectedMenuOption = getUserInput();
        int userSelectedBookToCheckout = userSelectedMenuOption - SELECTION_OFFSET;

        if (userSelectedMenuOption == -2) {
            return;
        }
        else if (userSelectedMenuOption == -1) {
            printer.printerEnterOnlyNumbers();
        }
        else if (userSelectedMenuOption > application.getAvailableBookList().size()) {
            printer.printEnterValidNumber();
        }
        else{
            Book selectedBook = library.getAvailableBookList().get(userSelectedBookToCheckout);
            library.checkOutBook(selectedBook);
            printer.printSuccesfulCheckoutMessage();
        }
    }

    public void performReturnBookOperation(Library library) {
        final int SELECTION_OFFSET = 1;
        final boolean INCLUDE_BACK_INSTRUCTIONS = true;

        printer.printHeading("Select the Number Of The Book To Return", INCLUDE_BACK_INSTRUCTIONS);
        printer.printEnumeratedList(application.getCheckedOutBookList());
        int userSelectedMenuOption = getUserInput();
        int userSelectedBookToCheckout = userSelectedMenuOption - SELECTION_OFFSET;

        if (userSelectedMenuOption == -2) {
            return;
        }
        else if (userSelectedMenuOption == -1) {
            printer.printerEnterOnlyNumbers();
        }
        else if (userSelectedMenuOption > application.getCheckedOutBookList().size()) {
            printer.printEnterValidNumber();
        }
        else{
            Book selectedBook = library.getCheckedOutBookList().get(userSelectedBookToCheckout);
            library.returnBook(selectedBook);
            printer.printSuccessfullReturnMessage();
        }
    }
}
