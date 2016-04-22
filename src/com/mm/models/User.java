package com.mm.models;

public class User {

    private final String id;
    private final String password;

    public User(String id, String password) {

        this.id = id;
        this.password = password;
    }

    public String getID() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public boolean verifyCredentials(String id, String password) {
        return ((this.id == id) && (this.password == password));
    }
}
