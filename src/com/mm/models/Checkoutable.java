package com.mm.models;

public interface Checkoutable {
    void checkOutItem(User user);
    void returnItem(User user);
    boolean isCheckedOut();
    User getOwner();
}
