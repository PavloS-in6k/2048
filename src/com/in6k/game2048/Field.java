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
        addRandomCell();
        addRandomCell();
    }

    protected void addRandomCell() {
        List<Cell> emptyCellList = new ArrayList<>();
        for (List<Cell> cellRow : field) {
            for (Cell cell : cellRow) {
                if (cell.getValue() == 0)
                    emptyCellList.add(cell);
            }
        }
        emptyCellList.get(getAnRandomCoordForTable(emptyCellList.size())).increment();
    }

    private int getAnRandomCoordForTable(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }

    public String getFieldView() {
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
