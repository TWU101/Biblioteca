package com.mm.utilities;

import com.mm.applications.Application;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

public class InputHandlerTest {
    private Application application;
    private InputHandler inputHandler;
    private Printer printer;

    @Before
    public void setUp() throws Exception {
        application = mock(Application.class);
        System.setIn(new ByteArrayInputStream("".getBytes()));
        printer = mock(Printer.class);
        inputHandler = new InputHandler(application, printer);
    }


    @Test
    public void shouldReturn2WhenInputIs2() {
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        inputHandler= new InputHandler(application, printer);
        assertEquals(2, inputHandler.getUserInput());
    }

    @Test
    public void shouldReturnNegativeOneWhenInputIsNotANumber() {
        String input = "a%#";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        inputHandler= new InputHandler(application, printer);
        assertEquals(-1, inputHandler.getUserInput());
    }

    @Test
    public void shouldCallMethodToPrintNoMoreBackMessage(){
        inputHandler.performSelectedMenuOption((-2));
        verify(printer, times(1)).printCantGoBack();
    }

    @Test
    public void shouldPrintMessageToOnlyInputValidIntegers(){
        inputHandler.performSelectedMenuOption((-1));
        verify(printer, times(1)).printerEnterOnlyNumbers();
    }

    @Test
    public void shouldReturnFalseWhenUserInputsQuitCommand(){
        assertFalse(inputHandler.performSelectedMenuOption((0)));
    }

    @Test
    public void shouldCallMethodToPrintCompleteLibrary(){
        inputHandler.performSelectedMenuOption(1);
        verify(application, times(1)).printCompleteLibrary();
    }

    @Test
    public void shouldCallMethodToCheckOutBook(){
        inputHandler.performSelectedMenuOption(2);
        verify(application, times(1)).checkOutBook();
    }

    @Test
    public void shouldCallMethodToReturnBook(){
        inputHandler.performSelectedMenuOption(3);
        verify(application, times(1)).returnBook();
    }



}