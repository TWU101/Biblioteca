package com.mm.models;

public interface Checkoutable {
    void checkOutItem();
    void returnItem();
    boolean isCheckedOut();
}
