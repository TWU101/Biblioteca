package com.mm.models;

public class User {

    private String id;
    private String password;
    private String name;
    private String email;
    private String phone;

    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public void setInfo(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getID() {
        return id;
    }

    public String getPassword() {
        return password;
    }


    @Override
    public boolean equals(Object user) {
        if(user instanceof User){
            User toCompare = (User) user;
            return ((this.id.equals(toCompare.id)) && (this.password.equals(toCompare.password)));
        }
        return false;
    }

    @Override
    public String toString() {
        return  "Name: " + name + "\n" +
                "Phone: " + phone + "\n" +
                "Email: " + email + "\n";
    }
}

