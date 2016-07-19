package com.in6k.game2048;

import java.util.Random;

public class Cell {
    private int value;

    Cell() {
        value = 0;
    }

    protected Cell(int value) {
        this.value = value;
    }

    public Cell increment() {
        if (value == 0) {
            value = 2;
        } else {
            value *= 2;
        }
        return this;
    }

    public int getValue() {
        return value;
    }


    public static Cell generateNewRandomValueCell() {
        Cell cell = new Cell();
        cell.increment();
        Random random = new Random();
        if (random.nextInt(4) == 3) {
            cell.increment();
        }
        return cell;
    }


}
