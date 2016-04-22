package com.mm.models;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class BookTest {

    @Test
    public void shouldCreateBookThatIsNotCheckedOutByDefault(){
        Book book = new Book("Name", "Author", 2016);
        assertFalse(book.isCheckedOut());
    }
}