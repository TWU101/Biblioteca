package com.mm;

import java.util.List;

public class Printer {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printList(List list) {
        for (Object object : list) {
            System.out.println(object);
        }
    }

    public void printSeperator(){
        System.out.println("============================");
    }

    public void printBlankLine(){
        System.out.println();
    }
}