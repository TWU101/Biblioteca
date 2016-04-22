package com.mm.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserTest {

    private User user;
    private String id;
    private String password;

    @Before
    public void setUp() {
        id = "123-4567";
        password = "password";
        user = new User(id, password);
    }

    @Test
    public void shouldCreateUserWithCredentials(){
        assertEquals(id, user.getID());
        assertEquals(password, user.getPassword());
    }

    @Test
    public void shouldReturnTrueIfSuppliedCredentialsMatchUserData(){
        boolean userExists = user.verifyCredentials(id, password);

        assertTrue(userExists);
    }

    @Test
    public void shouldReturnFalseIfSuppliedIDDoesNotMatchUserID(){
        String wrongID = "999-8765";
        boolean userExists = user.verifyCredentials(wrongID, password);

        assertFalse(userExists);
    }

    @Test
    public void shouldReturnFalseIfSuppliedPasswordDoesNotMatchUserPassword(){
        String wrongPassword = "wrongPassword";
        boolean userExists = user.verifyCredentials(id, wrongPassword);

        assertFalse(userExists);
    }
}
