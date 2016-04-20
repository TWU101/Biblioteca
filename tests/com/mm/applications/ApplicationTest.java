package com.mm.applications;

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
        assertEquals(4, application.getCompleteLibrary().size());
    }
}