package com.mm.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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

    @Test
    public void shouldReduceAvailableBookListSizeByOneWhenCheckingOutABook(){
        final int REDUCED_AMOUNT = 1;
        Book book1 = new Book("Name1", "Author1", 2016);
        Book book2 = new Book("Name2", "Author2", 2015);
        library.addToLibrary(book1);
        library.addToLibrary(book2);

        int sizeBeforeCheckout = library.getAvailableBookList().size();
        library.checkOutBook(book1);
        assertEquals(sizeBeforeCheckout-REDUCED_AMOUNT, library.getAvailableBookList().size());
    }

    @Test
    public void shouldReturnCheckedOutBookAndSetBookCheckoutToFalse(){
        Book book = new Book("Name", "Author", 2016);
        library.checkOutBook(book);
        library.returnBook(book);
        assertFalse(book.checkedOut);
    }

    @Test
    public void shouldIncreaseAvailableBookListSizeByOneWhenReturningABook(){
        final int INCREASE_AMOUNT = 1;
        Book book1 = new Book("Name1", "Author1", 2016);
        Book book2 = new Book("Name2", "Author2", 2015);
        library.addToLibrary(book1);
        library.addToLibrary(book2);

        library.checkOutBook(book1);
        int sizeBeforeReturn = library.getAvailableBookList().size();
        library.returnBook(book1);
        assertEquals(sizeBeforeReturn+INCREASE_AMOUNT, library.getAvailableBookList().size());
    }

}