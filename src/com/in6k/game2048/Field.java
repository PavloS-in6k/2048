package com.in6k.game2048;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.in6k.game2048.Cell.generateNewRandomValueCell;

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
        addRandomCell();
        addRandomCell();
    }

    protected void addRandomCell() {
        int i = getAnRandomCoordForTable();
        int k = getAnRandomCoordForTable();
        while (field.get(i).get(k).getValue() != 0) {
            i = getAnRandomCoordForTable();
            k = getAnRandomCoordForTable();
        }
        field.get(i).set(k, generateNewRandomValueCell());
    }

    private int getAnRandomCoordForTable() {
        Random random = new Random();
        return random.nextInt(FIELD_LENGTH);
    }

    protected Cell generateEmptyCell() {
        return new Cell();
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
