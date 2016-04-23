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
    public void shouldReturnInvalidOptionWhenInputIsNotANumber() {
        String input = "a%#";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        IOHandler = new IOHandler(printer);
        assertEquals(MenuOption.INVALID_OPTION, IOHandler.getUserInput());
    }

    @Test
    public void shouldReturnBackOptionWhenInputIsBorBack() {
        String input = "back";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        IOHandler = new IOHandler(printer);
        assertEquals(MenuOption.BACK_OPTION, IOHandler.getUserInput());
    }

    @Test
    public void shouldReturnQuitOptionWhenInputIsQorQuit() {
        String input = "quit";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        IOHandler = new IOHandler(printer);
        assertEquals(MenuOption.QUIT_OPTION, IOHandler.getUserInput());
    }





}