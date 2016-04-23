package com.mm.models;

public class User {

    public String id;
    public String password;

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



//    public boolean verifyCredentials(Object user) {
//        return ((this.id ==  user.id) && (this.password == user.password));
//    }

    @Override
    public boolean equals(Object user) {
        if(user instanceof User){
            User toCompare = (User) user;
            return ((this.id.equals(toCompare.id)) && (this.password.equals(toCompare.password)));
        }
        return false;
    }


}

