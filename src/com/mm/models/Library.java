package com.mm.models;

import java.util.ArrayList;

public class Library {
    private ArrayList<Checkoutable> library = new ArrayList<>();
    public int getLibrarySize() {
        return library.size();
    }

    public void addToLibrary(Checkoutable item) {
        library.add(item);
    }

    public ArrayList<Checkoutable> getAvailableItemList() {
        ArrayList<Checkoutable> availableItems = new ArrayList<>();
        for (Checkoutable item : library) {
            if (!item.isCheckedOut()){
                availableItems.add(item);
            }
        }
        return availableItems;
    }

    public ArrayList<Checkoutable> getCheckedOutItemList(User user) {
        ArrayList<Checkoutable> checkedOutItems = new ArrayList<>();
        for (Checkoutable item : library) {
            if (item.isCheckedOut()){
                if (item.getOwner().equals(user))
                checkedOutItems.add(item);
            }
        }
        return checkedOutItems;
    }

    public ArrayList<Checkoutable> getCompleteLibrary() {
        return library;
    }

    public void checkOutItem(int index, User user) {
        this.getAvailableItemList().get(index).checkOutItem(user);
    }

    public void returnItem(int index, User user) {
        this.getCheckedOutItemList(user).get(index).returnItem(user);
    }
}
