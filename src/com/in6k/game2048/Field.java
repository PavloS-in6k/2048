package com.in6k.game2048;

import com.in6k.game2048.RandomGenerator.RandomGenerator;
import com.in6k.game2048.RandomGenerator.RandomGeneratorImpl;

import java.util.ArrayList;
import java.util.List;

public class Field {
    private int score;
    private List<List<Cell>> field;
    public static final int FIELD_LENGTH = 4;
    private RandomGenerator random = new RandomGeneratorImpl();

    protected void setRandom(RandomGenerator random) {
        this.random = random;
    }

    public Field() {
        field = new ArrayList<>();
        generateNewField();
    }

    protected Field(List<List<Cell>> field) {
        this.field = field;
    }

    List<List<Cell>> getField() {
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
        List<Cell> emptyCellList = getEmptyCells();
        int randomIndex = random.getValue(emptyCellList.size());
        emptyCellList.get(randomIndex).increment();
        if (random.getValue(3) == 3) {
            emptyCellList.get(randomIndex).increment();
        }
    }

    protected List<Cell> getEmptyCells() {
        List<Cell> emptyCellList = new ArrayList<>();
        for (List<Cell> cellRow : field) {
            for (Cell cell : cellRow) {
                if (cell.getValue() == 0)
                    emptyCellList.add(cell);
            }
        }
        return emptyCellList;
    }

    protected List<Integer> getCellsValuesAsList() {
        List<Integer> resultList = new ArrayList<>();

        for (List<Cell> cellsrow : field) {
            for (Cell cell : cellsrow) {
                resultList.add(cell.getValue());
            }
        }

        return resultList;
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

    public int getScore() {
        return score;
    }

}
