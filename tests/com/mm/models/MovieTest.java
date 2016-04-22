package com.mm.models;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class MovieTest {

    @Test
    public void shouldCreateMovieThatIsNotCheckedOutByDefault(){
        Movie movie = new Movie("Name", 2016, "Director", "Rating");
        assertFalse(movie.isCheckedOut());
    }
}