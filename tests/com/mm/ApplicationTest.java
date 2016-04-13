package com.mm;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ApplicationTest {

    private Application application;

    @Before
    public void setUp() throws Exception {
        application = new Application();
        application.setUp();
    }

    @Test
    public void shouldSetUpLibraryBooks() {
        assertEquals(4, application.getLibrarySize());
    }


    @Test
    public void shouldCheckOutBook(){
        Book book = new Book("Test", "Test Author", 2016);
//        assertTrue(application.checkOutBook(book));
    }

}