package com.mm.applications;

import org.junit.Before;

public class ApplicationTest {

    private Application application;

    @Before
    public void setUp() throws Exception {
        application = new Application();
        application.setUp();
    }


}