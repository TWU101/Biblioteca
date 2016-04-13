package com.mm.utilities;

import com.mm.applications.Application;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class InputHandlerTest {


    @Test
    public void shouldReturn2WhenInputIs2() {
        Application application = new Application();
        InputHandler inputHandler= new InputHandler(application);

        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(2, inputHandler.getUserInput(new Scanner(System.in)));
    }

    @Test
    public void shouldReturnNegativeOneWhenInputIsNotANumber() {
        Application  application = new Application();
        InputHandler inputHandler= new InputHandler(application);

        String input = "a%#";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(-1, inputHandler.getUserInput(new Scanner(System.in)));
    }

    @Test
    public void shouldCallMethodToPrintCompleteLibrary(){
        Application application = mock(Application.class);
        InputHandler inputHandler = new InputHandler(application);
        inputHandler.performSelectedMenuOption(1);
        verify(application, times(1)).printCompleteLibrary();
    }

    @Test
    public void shouldCallMethodToCheckOutBook(){
        Application application = mock(Application.class);
        InputHandler inputHandler = new InputHandler(application);
        inputHandler.performSelectedMenuOption(2);
        verify(application, times(1)).checkOutBook();
    }
}