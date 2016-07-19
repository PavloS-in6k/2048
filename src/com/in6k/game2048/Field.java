package com.in6k.game2048;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Field {
    private List<List<Cell>> field;
    public static final int FIELD_LENGTH = 4;

    Field() {
        field = new ArrayList<>();
    }

    public List<List<Cell>> getField() {
        return this.field;
    }

    public void generateNewField() {
        field.clear();
        for (int i = 0; i < FIELD_LENGTH; i++) {
            field.add(new ArrayList<>());
            for (int k = 0; k < FIELD_LENGTH; k++) {
                field.get(i).add(new Cell());
            }
        }
        addFirstTwoCells();

    }

    private void addFirstTwoCells() {
        Random random = new Random();
        field.get(random.nextInt(FIELD_LENGTH-1)).set(random.nextInt(FIELD_LENGTH-1), generateNewValueCell());
        field.get(random.nextInt(FIELD_LENGTH-1)).set(random.nextInt(FIELD_LENGTH-1), generateNewValueCell());
    }

    protected Cell generateEmptyCell() {
        return new Cell();
    }

    protected Cell generateNewValueCell() {
        Cell cell = new Cell();
        cell.increment();
        Random random = new Random();
        if (random.nextInt(4) == 3) {
            cell.increment();
        }
        return cell;
    }
}
