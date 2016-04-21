package com.mm.utilities;

import com.mm.applications.Application;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class IOHandlerTest {
    private Application application;
    private IOHandler IOHandler;
    private Printer printer;

    @Before
    public void setUp() throws Exception {
        application = mock(Application.class);
        System.setIn(new ByteArrayInputStream("".getBytes()));
        printer = mock(Printer.class);
        IOHandler = new IOHandler(printer);
    }


    @Test
    public void shouldReturn2WhenInputIs2() {
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        IOHandler = new IOHandler(printer);
        assertEquals(2, IOHandler.getUserInput());
    }

    @Test
    public void shouldReturnNegativeOneWhenInputIsNotANumber() {
        String input = "a%#";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        IOHandler = new IOHandler(printer);
        assertEquals(MenuOption.INVALID_OPTION, IOHandler.getUserInput());
    }

//    @Test
//    public void shouldCallMethodToPrintNoMoreBackMessage(){
//        IOHandler.performSelectedMenuOption((MenuOption.BACK_OPTION));
//        verify(printer, times(1)).printCantGoBack();
//    }
//
//    @Test
//    public void shouldPrintMessageToOnlyInputValidIntegers(){
//        IOHandler.performSelectedMenuOption((MenuOption.INVALID_OPTION));
//        verify(printer, times(1)).printEnterOnlyNumbers();
//    }
//
//    @Test
//    public void shouldReturnFalseWhenUserInputsQuitCommand(){
//        assertFalse(IOHandler.performSelectedMenuOption((0)));
//    }
//
//    @Test
//    public void shouldCallMethodToPrintCompleteLibrary(){
//        IOHandler.performSelectedMenuOption(1);
//        verify(application, times(1)).printCompleteLibrary();
//    }
//
//    @Test
//    public void shouldCallMethodToCheckOutBook(){
//        IOHandler.performSelectedMenuOption(2);
//        verify(application, times(1)).checkOutBook();
//    }
//
//    @Test
//    public void shouldCallMethodToReturnBook(){
//        IOHandler.performSelectedMenuOption(3);
//        verify(application, times(1)).returnBook();
//    }



}