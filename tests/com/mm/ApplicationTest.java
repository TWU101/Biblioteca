package com.mm;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ApplicationTest {

    @Test
    public void shouldSetUpLibraryBooks() {
        Application application = new Application();
        application.setUp();
        assertEquals(application.getLibrary().size(), 4);
    }




}