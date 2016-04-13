package com.mm;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookTest {

    @Test
    public void shouldReturnTrueWhenComparingTwoBooksWithSameInfo(){
        Book book1 = new Book("Title", "Author", 2016);
        Book book2 = new Book("Title", "Author", 2016);
        assertTrue(book1.equals(book2));
    }

    @Test
    public void shouldReturnFalseWhenComparingTwoBooksWithSameInfoExceptTitle(){
        Book book1 = new Book("Titl", "Author", 2016);
        Book book2 = new Book("Title", "Author", 2016);
        assertFalse(book1.equals(book2));
    }

    @Test
    public void shouldReturnFalseWhenComparingTwoBooksWithSameInfoExceptAuthor(){
        Book book1 = new Book("Title", "Author", 2016);
        Book book2 = new Book("Title", "Autho", 2016);
        assertFalse(book1.equals(book2));
    }

    @Test
    public void shouldReturnFalseWhenComparingTwoBooksWithSameInfoExceptYearPublished(){
        Book book1 = new Book("Title", "Author", 2016);
        Book book2 = new Book("Title", "Author", 2012);
        assertFalse(book1.equals(book2));
    }

    @Test
    public void shouldReturnFalseWhenComparingTwoBooksWithNoSameInfo(){
        Book book1 = new Book("Title", "Author", 2016);
        Book book2 = new Book("Test", "Something", 2012);
        assertFalse(book1.equals(book2));
    }
}