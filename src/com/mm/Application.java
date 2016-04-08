package com.mm;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Application {
    private List<String> menuOptions = asList("1) - List Books:");
    private ArrayList<Book> library = new ArrayList<>();


    public List<String> getMenuOptions() {
        return menuOptions;
    }
}