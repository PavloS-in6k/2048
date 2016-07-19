package com.in6k.game2048;

public class Cell {
    private int value;

    Cell() {
        value = 0;
    }

    public void increment() {
        if (value == 0) {
            value = 2;
        } else {
            value *= 2;
        }
    }

    public int getValue() {
        return value;
    }
}
