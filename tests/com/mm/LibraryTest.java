package com.mm;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;


public class LibraryTest {
    Library library = new Library();

    @Test
    public void shouldAddBookToLibrary() {
        Book book = mock(Book.class);
        int previousLibrarySize = library.getLibrarySize();
        library.addToLibrary(book);
        assertEquals(library.getLibrarySize(), previousLibrarySize+1);
    }

    @Test
    public void shouldCheckOutBookAndSetBookCheckoutToTrue(){
        Book book = new Book("Name", "Author", 2016);
        library.checkOutBook(book);
        assertTrue(book.checkedOut);
    }

}