package com.mm.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
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
    public void shouldReduceAvailableBookListSizeByOneWhenCheckingOutABook(){
        final int REDUCED_AMOUNT = 1;
        Book book1 = new Book("Name1", "Author1", 2016);
        Book book2 = new Book("Name2", "Author2", 2015);
        library.addToLibrary(book1);
        library.addToLibrary(book2);

        int sizeBeforeCheckout = library.getAvailableItemList().size();
        library.checkOutItem(0);
        assertEquals(sizeBeforeCheckout-REDUCED_AMOUNT, library.getAvailableItemList().size());
    }



    @Test
    public void shouldIncreaseAvailableBookListSizeByOneWhenReturningABook(){
        final int INCREASE_AMOUNT = 1;
        Book book1 = new Book("Name1", "Author1", 2016);
        Book book2 = new Book("Name2", "Author2", 2015);
        library.addToLibrary(book1);
        library.addToLibrary(book2);

        library.checkOutItem(0);
        int sizeBeforeReturn = library.getAvailableItemList().size();
        library.returnItem(0);
        assertEquals(sizeBeforeReturn+INCREASE_AMOUNT, library.getAvailableItemList().size());
    }

}