package com.mm.applications;

import com.mm.models.Book;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

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
        Book book = mock(Book.class);
        application.checkOutBook();
        verify(book, times(1)).checkOut();
    }

}