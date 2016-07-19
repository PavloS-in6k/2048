package com.in6k.game2048;

public class Cell {
    private int value = 2;

    Cell() {
    }

    public void increment() {
        value *= 2;
    }

    public int getValue() {
        return value;
    }
}
