package com.mm.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
        String correctID = "123-4567";
        String correctPassword = "password";

        User user2 = new User(correctID, correctPassword);
        assertEquals(user, user2);

    }

    @Test
    public void shouldReturnFalseIfSuppliedIDDoesNotMatchUserID(){
        String wrongID = "000-0000";
        String correctPassword = "password";

        User user2 = new User(wrongID, correctPassword);
        assertNotEquals(user, user2);
    }

    @Test
    public void shouldReturnFalseIfSuppliedPasswordDoesNotMatchUserPassword(){
        String correctID = "000-0000";
        String wrongPassword = "password";

        User user2 = new User(correctID, wrongPassword);
        assertNotEquals(user, user2);
    }
}
