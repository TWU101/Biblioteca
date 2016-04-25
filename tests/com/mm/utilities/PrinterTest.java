package com.mm.utilities;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class PrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    Printer printer = new Printer();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldPrintTestMessage() {
        printer.printMessage("test");
        assertThat(outContent.toString(), is("test\n"));
    }



}