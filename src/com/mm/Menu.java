package com.mm;

import java.util.List;

import static java.util.Arrays.asList;

public class Menu {
    private List<String> menuOptions = asList("1) - List Books:");

    public List<String> getMenuOptions() {
        return menuOptions;
    }
}