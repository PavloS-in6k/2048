package com.in6k.game2048;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Field {
    private List<List<Cell>> field;
    public static final int FIELD_LENGTH = 4;

    public Field() {
        field = new ArrayList<>();
        generateNewField();
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
        int i = random.nextInt(FIELD_LENGTH - 1);
        int k = random.nextInt(FIELD_LENGTH - 1);
        field.get(i).set(k, generateNewValueCell());
        i = random.nextInt(FIELD_LENGTH - 1);
        k = random.nextInt(FIELD_LENGTH - 1);
        field.get(i).set(k, generateNewValueCell());
    }

    protected Cell generateEmptyCell() {
        return new Cell();
    }

    protected Cell generateNewValueCell() {
        Cell cell = new Cell();
        cell.increment();
        Random random = new Random();
        if (random.nextInt(3) == 3) {
            cell.increment();
        }
        return cell;
    }

    public String getFieldViev() {
        String fieldViev = "";
        String delimeter = "\n";
        for (int i = 0; i < FIELD_LENGTH; i++) {
            for (int k = 0; k < FIELD_LENGTH; k++) {
                fieldViev += field.get(i).get(k).getValue() + "\t";
            }
            fieldViev += delimeter;
        }
        return fieldViev;
    }
}
